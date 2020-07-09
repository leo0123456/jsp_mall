package com.lmonkey.servlet.order;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_ORDER;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_CATEGORYDao;
import com.lmonkey.service.LMONKEY_ORDERDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;
import com.lmonkey.service.LMONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/orderselect")
public class orderselect extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<LMONKEY_CATEGORY> flist =  LMONKEY_CATEGORYDao.selectCat("father");
        request.setAttribute("flist", flist);

        ArrayList<LMONKEY_CATEGORY> clist =  LMONKEY_CATEGORYDao.selectCat("child");
        request.setAttribute("clist", clist);

        String uid = request.getParameter("id");

        ArrayList<LMONKEY_ORDER> list= LMONKEY_ORDERDao.selectbyid(uid);

        //放到请求对象域里
        request.setAttribute("orderlist", list);

        request.getRequestDispatcher("myorderq.jsp").forward(request, response);
    }
}
