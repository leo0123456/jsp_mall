package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_USER;


public class LMONKEY_USERDao {
    /**
     * 加入数所库
     * @param
     * @return
     */
    public static int insert(LMONKEY_USER u) {
        String sql = "insert into LMONKEY_USER values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?)";

        Object[] params = {
                u.getUSER_ID(),
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_SEX(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBILE(),

                u.getUSER_STATUS()};

        return Basedao.exectuIUD(sql, params);
    }

    /**
     * 删除一个用户
     * @param
     * @return
     */
    public static int del(String id) {

        String sql = "delete from LMONKEY_USER where USER_ID=? and USER_STATUS!=2";

        Object[] params = {id};

        return Basedao.exectuIUD(sql, params);
    }


    public static int update(LMONKEY_USER u) {
        String sql = "update LMONKEY_USER set USER_NAME=?, USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?, '%y-%m-%d'),USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_STATUS=? where USER_ID = ?";

        Object[] params = {
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_SEX(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBILE(),

                u.getUSER_STATUS(),
                u.getUSER_ID()};

        return Basedao.exectuIUD(sql, params);
    }

    public static int selectByName(String id) {
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
            String sql = "select count(*) from LMONKEY_USER where USER_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt(1);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            Basedao.closeall(rs, ps, conn);
        }



        return count;
    }


    /**
     * 获取总记录数和总页数
     * @param count
     * @return
     */

    public static int[] totalPage(int count, String keyword) {
        // 0 总记录数， 1， 页数
        int arr[] = {0, 1};

        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
            String sql = "";

            if(keyword!=null) {
                sql = "select count(*) from LMONKEY_USER where USER_NAME like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%"+keyword+"%");
            }else{
                sql = "select count(*) from LMONKEY_USER";

                ps = conn.prepareStatement(sql);

            }





            rs = ps.executeQuery();

            while(rs.next()) {
                arr[0]= rs.getInt(1);

                if(arr[0]%count==0){
                    arr[1] = arr[0]/count;
                }else{
                    arr[1] = arr[0]/count+1;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            Basedao.closeall(rs, ps, conn);
        }



        return arr;
    }


    public static ArrayList<LMONKEY_USER> selectAll(int cpage, int count,String keyword) {
        ArrayList<LMONKEY_USER> list = new ArrayList<LMONKEY_USER>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "";

            if(keyword!=null) {
                sql = "select * from LMONKEY_USER where USER_NAME like ? order by USER_BIRTHDAY desc limit ?, ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%"+keyword+"%");
                ps.setInt(2, (cpage-1)*count);
                ps.setInt(3, count);
            }else{

                sql = "select * from LMONKEY_USER order by USER_BIRTHDAY desc limit ?, ?";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, (cpage-1)*count);
                ps.setInt(2, count);
            }


            rs = ps.executeQuery();

            while(rs.next()) {
                LMONKEY_USER u = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("USER_BIRTHDAY"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getInt("USER_STATUS")

                );


                list.add(u);

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
     * 通过ID查找用户
     * @return
     */
    public static LMONKEY_USER selectByID(String id) {

        LMONKEY_USER u = null;

        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday  from LMONKEY_USER m where USER_ID=?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, id);


            rs = ps.executeQuery();

            while(rs.next()) {
                u = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),

                        rs.getInt("USER_STATUS")

                );




            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return u;
    }

    public static int selectByNM(String name, String pwd){
        int count =0;

        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
            String sql = "select count(*) from LMONKEY_USER where USER_ID=? and USER_PASSWORD=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt(1);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            Basedao.closeall(rs, ps, conn);
        }


        return count;

    }
    /**
     * 通过用户名和密码查询用户信息
     * @param name
     * @param pwd
     * @return
     */

    public static LMONKEY_USER selectAdmin(String name, String pwd) {
        LMONKEY_USER u = null;

        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday  from LMONKEY_USER m where USER_ID=? and USER_PASSWORD=?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);

            rs = ps.executeQuery();

            while(rs.next()) {
                u = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),

                        rs.getInt("USER_STATUS")

                );




            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return u;


    }



}
