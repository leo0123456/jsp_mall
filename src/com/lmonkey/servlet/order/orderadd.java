package com.lmonkey.servlet.order;

import com.lmonkey.entity.LMONKEY_ORDER;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_ORDERDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/orderadd")
public class orderadd extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LMONKEY_PRODUCT p = null;

        String pid = request.getParameter("id");



        HttpSession session =  request.getSession();

        String isLogin = (String)session.getAttribute("isLogin");

        LMONKEY_USER user=(LMONKEY_USER)session.getAttribute("name");

        if(user!=null && isLogin.equals("1")) {

            String uid = (String)user.getUSER_ID();

            p  = LMONKEY_PRODUCTDao.selectById(Integer.parseInt(pid));


            LMONKEY_ORDER order = new LMONKEY_ORDER(
                    0,
                    p.getPRODUCT_ID(),
                    p.getPRODUCT_FILENAME(),
                    p.getPRODUCT_FINAME(),
                    p.getPRODUCT_NAME(),
                    p.getPRODUCT_PRICE(),
                    uid
            );

            LMONKEY_ORDERDao.insert(order);
        } else{

            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('登录后，再购买')");
            out.write("location.href='login.jsp'");
            out.write("</script>");
            out.close();
            return;
        }


        response.sendRedirect("ok2.jsp");



    }
}
