package com.lmonkey.servlet.product;

import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_PRODUCTDao;
import com.lmonkey.service.LMONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_doproductdel")
public class DoProductDel extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String id= request.getParameter("id");

        int count = LMONKEY_PRODUCTDao.del(id);


        //成功或失败重定向到哪里

        if(count >0 ) {

            response.sendRedirect("admin_productselect?cp="+request.getParameter("cpage"));
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('用户删除失败')");
            out.write("location.href='manage/admin_douserselect?cp="+request.getParameter("cpage")+"'");
            out.write("</script>");

        }
    }
}
