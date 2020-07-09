package com.lmonkey.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_CATEGORYDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;
import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class ProductSelect
 */
@WebServlet("/manage/admin_productselect")
public class ProductSelect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int cpage = 1; //当前页
        int count = 5; //每页显示条数

        String cp = request.getParameter("cp");

        if(cp!=null)
        {
            cpage = Integer.parseInt(cp);
        }

        int arr[] = LMONKEY_PRODUCTDao.totalPage(count);

        ArrayList<LMONKEY_PRODUCT>  plist = LMONKEY_PRODUCTDao.selectAll(cpage, count);

        request.setAttribute("plist", plist);
        request.setAttribute("tsum", arr[0]);
        request.setAttribute("tpage", arr[1]);
        request.setAttribute("cpage", cpage);

        request.getRequestDispatcher("admin_product.jsp").forward(request, response);
    }



}

