package com.lmonkey.service;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_ORDER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LMONKEY_ORDERDao {
    public static int insert(LMONKEY_ORDER order){
        String sql = "insert into lmonkey_order values(null,?,?,?,?,?,?)";

        Object[] params = {
                order.getOrder_p_id(),
                order.getOrder_p_filename(),
                order.getOrder_p_finame(),
                order.getOrder_p_name(),
                order.getOrder_p_price(),
                order.getOrder_u_id(),
        };

        return Basedao.exectuIUD(sql, params);
    }


    public static ArrayList<LMONKEY_ORDER> selectbyid(String uid) {
        ArrayList<LMONKEY_ORDER> list = new ArrayList<LMONKEY_ORDER>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select *  from LMONKEY_ORDER  where order_u_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            rs = ps.executeQuery();

            while(rs.next()) {
                LMONKEY_ORDER order = new LMONKEY_ORDER(
                        rs.getInt("order_id"),
                        rs.getInt("order_p_id"),
                        rs.getString("order_p_filename"),
                        rs.getString("order_p_finame"),
                        rs.getString("order_p_name"),
                        rs.getInt("order_p_price"),
                        rs.getString("order_u_id")

                );


                list.add(order);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return list;

    }

    public static ArrayList<LMONKEY_ORDER> selectall() {
        ArrayList<LMONKEY_ORDER> list = new ArrayList<LMONKEY_ORDER>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select *  from LMONKEY_ORDER";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                LMONKEY_ORDER order = new LMONKEY_ORDER(
                        rs.getInt("order_id"),
                        rs.getInt("order_p_id"),
                        rs.getString("order_p_filename"),
                        rs.getString("order_p_finame"),
                        rs.getString("order_p_name"),
                        rs.getInt("order_p_price"),
                        rs.getString("order_u_id")

                );


                list.add(order);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return list;

    }

}
