package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.entity.LMONKEY_USER;


public class LMONKEY_PRODUCTDao {

    public static int insert(LMONKEY_PRODUCT p) {
        String sql = "insert into LMONKEY_PRODUCT values(null, ?, ?,?,?,?,?,?)";


        Object[] params = {
                p.getPRODUCT_NAME(),
                p.getPRODUCT_DESCRIPTION(),
                p.getPRODUCT_PRICE(),
                p.getPRODUCT_FID(),
                p.getPRODUCT_CID(),
                p.getPRODUCT_FILENAME(),
                p.getPRODUCT_FINAME()
        };

        return Basedao.exectuIUD(sql, params);
    }


    public static ArrayList<LMONKEY_PRODUCT> selectAll(int cpage, int count) {
        ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;


        try {
            String sql = "select * from LMONKEY_PRODUCT order by PRODUCT_ID desc limit ?, ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (cpage-1)*count);
            ps.setInt(2, count);
            rs = ps.executeQuery();

            while (rs.next()) {
                LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_CID"),
                        rs.getString("PRODUCT_FILENAME"),
                        rs.getString("PRODUCT_FINAME")
                );


                list.add(p);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }


        return list;
    }


    public static LMONKEY_PRODUCT selectById(int id) {
        LMONKEY_PRODUCT p = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;


        try {
            String sql = "select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                p = new LMONKEY_PRODUCT(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_CID"),
                        rs.getString("PRODUCT_FILENAME"),
                        rs.getString("PRODUCT_FINAME")
                );


            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }


        return p;
    }

    public static ArrayList<LMONKEY_PRODUCT> selectAllByFid(int fid) {
        ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;


        try {
            String sql = "select * from LMONKEY_PRODUCT where PRODUCT_FID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fid);
            rs = ps.executeQuery();

            while (rs.next()) {
                LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_CID"),
                        rs.getString("PRODUCT_FILENAME"),
                        rs.getString("PRODUCT_FINAME")
                );


                list.add(p);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }


        return list;
    }


    public static ArrayList<LMONKEY_PRODUCT> selectAllByCid(int cid) {
        ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;


        try {
            String sql = "select * from LMONKEY_PRODUCT where PRODUCT_CID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();

            while (rs.next()) {
                LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),

                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_CID"),
                        rs.getString("PRODUCT_FILENAME"),
                        rs.getString("PRODUCT_FINAME")
                );


                list.add(p);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }


        return list;
    }


    public static ArrayList<LMONKEY_PRODUCT> selectAllById(ArrayList<Integer> ids) {
        ArrayList<LMONKEY_PRODUCT> lastlylist = new ArrayList<LMONKEY_PRODUCT>();

        LMONKEY_PRODUCT p = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;


        try {
            for (int i = 0; i < ids.size(); i++) {

                String sql = "select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, ids.get(i));
                rs = ps.executeQuery();

                while (rs.next()) {
                    p = new LMONKEY_PRODUCT(
                            rs.getInt("PRODUCT_ID"),
                            rs.getString("PRODUCT_NAME"),
                            rs.getString("PRODUCT_DESCRIPTION"),
                            rs.getInt("PRODUCT_PRICE"),

                            rs.getInt("PRODUCT_FID"),
                            rs.getInt("PRODUCT_CID"),
                            rs.getString("PRODUCT_FILENAME"),
                            rs.getString("PRODUCT_FINAME")
                    );


                    lastlylist.add(p);

                }
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }


        return lastlylist;
    }


    public static int[] totalPage(int count) {
        // 0 总记录数， 1， 页数
        int arr[] = {0, 1};

        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            String sql = "";

            sql = "select count(*) from lmonkey_product";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                arr[0] = rs.getInt(1);

                if (arr[0] % count == 0) {
                    arr[1] = arr[0] / count;
                } else {
                    arr[1] = arr[0] / count + 1;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }


        return arr;
    }

    public static int del(String id) {

        String sql = "delete from LMONKEY_PRODUCT where PRODUCT_ID=?";

        Object[] params = {id};

        return Basedao.exectuIUD(sql, params);
    }



}
