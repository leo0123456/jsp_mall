package com.lmonkey.servlet.product;





import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class DoProductAdd
 */
@WebServlet("/manage/admin_doproductadd")
public class DoProductAdd extends HttpServlet {

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //创建SmartUpload对象
        SmartUpload su= new SmartUpload();

        //初使化
        su.initialize(this.getServletConfig(), request, response);

        //上传过程
        try {
            su.upload();
        } catch (SmartUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //获取上传的文件对象
        Files fs= su.getFiles();
        File f = fs.getFile(0);
        File f2 = fs.getFile(1);
        //获取上传的文件名称
        String fname = f.getFileName();

        String fname2 = f2.getFileName();


        try {
            su.save("images/product");
        } catch (SmartUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Request req1 = su.getRequest();


        String pname = req1.getParameter("productName");

        String id = req1.getParameter("parentId");
        String price = req1.getParameter("productPrice");
        String desc = req1.getParameter("productDesc");


        LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
                0,
                pname,
                desc,
                Integer.parseInt(price),
                Integer.parseInt(id.split("-")[0]),
                Integer.parseInt(id.split("-")[1]),
                fname,
                fname2
        );

        int count = LMONKEY_PRODUCTDao.insert(p);



        if(count >0 ) {

            response.sendRedirect("/manage/admin_productselect");
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('商品添加失败')");
            out.write("location.href='manage/admin_toproductadd'");
            out.write("</script>");

        }


    }

}

