package com.lmonkey.servlet.order;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/download")
public class download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String finame = request.getParameter("finame");

        response.addHeader("contentType","application/octet-stream");
        response.addHeader("content-Disposition","attachement; filename"+finame);

        InputStream in = getServletContext().getResourceAsStream("images/product/"+finame);

        ServletOutputStream out = response.getOutputStream();
        byte[] bs = new byte[10];
        int len=-1;
        while ((len=in.read(bs)) !=-1){
            out.write(bs,0,len);
        }
        out.close();
        in.close();

    }
}
