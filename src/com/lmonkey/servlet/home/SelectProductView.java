package com.lmonkey.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_CATEGORYDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class SelectProductView
 */
@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<LMONKEY_CATEGORY> flist =  LMONKEY_CATEGORYDao.selectCat("father");
        request.setAttribute("flist", flist);

        ArrayList<LMONKEY_CATEGORY> clist =  LMONKEY_CATEGORYDao.selectCat("child");
        request.setAttribute("clist", clist);

        String id = request.getParameter("id");

        //获取最近访问

        HttpSession session = request.getSession();

        //从SSESSIOn获取一下 ids

        ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");

        if(ids == null){
            ids = new ArrayList<Integer>();
        }

        //最多放5， 如果多出5个将第一个删除
        if(ids.size() >= 5) {
            ids.remove(0);
        }

        // 添加列表里， 但只要一份
        if(id!=null && (!ids.contains(Integer.parseInt(id)))) {
            ids.add(Integer.parseInt(id));

        }

        session.setAttribute("ids", ids);

        ids= (ArrayList<Integer>)session.getAttribute("ids");

        if(ids!=null) {

            ArrayList<LMONKEY_PRODUCT> lastlylist = LMONKEY_PRODUCTDao.selectAllById(ids);
            request.setAttribute("lastlylist", lastlylist);
        }


        LMONKEY_PRODUCT p = null;

        if(id !=null) {
            p = LMONKEY_PRODUCTDao.selectById(Integer.parseInt(id));
            request.setAttribute("p", p);
        }



        request.getRequestDispatcher("order.jsp").forward(request, response);
    }


}
