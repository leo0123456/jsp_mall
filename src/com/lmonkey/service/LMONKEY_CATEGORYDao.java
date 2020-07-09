package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_USER;

/**
 * 获取所有分类
 * @author Administrator
 *
 */
public class LMONKEY_CATEGORYDao {
    public static ArrayList<LMONKEY_CATEGORY> selectAll() {
        ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from LMONKEY_CATEGORY";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                LMONKEY_CATEGORY cate = new LMONKEY_CATEGORY(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")

                );


                list.add(cate);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return list;
    }
    /**
     * 查询分类，子分类和父级分类
     * @param flag  flag="father" flag="child"
     * @return
     */

    public static ArrayList<LMONKEY_CATEGORY> selectCat(String flag) {
        ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {

            String sql = null;

            if(flag!=null && flag.equals("father")){

                sql = "select * from LMONKEY_CATEGORY where CATE_PARENT_ID=0";
            }else{
                sql = "select * from LMONKEY_CATEGORY where CATE_PARENT_ID!=0";
            }
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                LMONKEY_CATEGORY cate = new LMONKEY_CATEGORY(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")

                );


                list.add(cate);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return list;
    }



    public static LMONKEY_CATEGORY selectById(int id) {

        LMONKEY_CATEGORY cate = null;

        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select *  from LMONKEY_CATEGORY  where CATE_ID=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);


            rs = ps.executeQuery();

            while(rs.next()) {
                cate = new LMONKEY_CATEGORY(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")

                );




            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return cate;
    }



    /**
     * 添加分类
     * @param cate
     * @return
     */

    public static int insert(LMONKEY_CATEGORY cate) {
        String sql = "insert into LMONKEY_category values(null, ?, ?)";

        Object[] params = {
                cate.getCATE_NAME(),
                cate.getCATE_PARENT_ID()
        };

        return Basedao.exectuIUD(sql, params);
    }



    public static int update(LMONKEY_CATEGORY cate) {
        String sql = "update LMONKEY_CATEGORY set CATE_NAME=?, CATE_PARENT_ID=?  where CATE_ID = ?";

        Object[] params = {
                cate.getCATE_NAME(),
                cate.getCATE_PARENT_ID(),
                cate.getCATE_ID()
        };

        return Basedao.exectuIUD(sql, params);
    }


    public static int del(int id) {
        String sql = "delete from LMONKEY_CATEGORY where CATE_ID=?";

        Object[] params = {id};

        return Basedao.exectuIUD(sql, params);

    }




}
