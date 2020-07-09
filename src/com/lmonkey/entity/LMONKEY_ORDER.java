package com.lmonkey.entity;

public class LMONKEY_ORDER {
    private  int order_id;
    private  int order_p_id;
    private  String order_p_filename;
    private  String order_p_finame;
    private  String order_p_name;
    private  int order_p_price;
    private  String order_u_id;

    public LMONKEY_ORDER(int order_id, int order_p_id, String order_p_filename, String order_p_finame, String order_p_name, int order_p_price, String order_u_id) {
        this.order_id = order_id;
        this.order_p_id = order_p_id;
        this.order_p_filename = order_p_filename;
        this.order_p_finame = order_p_finame;
        this.order_p_name = order_p_name;
        this.order_p_price = order_p_price;
        this.order_u_id = order_u_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_p_id() {
        return order_p_id;
    }

    public void setOrder_p_id(int order_p_id) {
        this.order_p_id = order_p_id;
    }

    public String getOrder_p_filename() {
        return order_p_filename;
    }

    public void setOrder_p_filename(String order_p_filename) {
        this.order_p_filename = order_p_filename;
    }

    public String getOrder_p_finame() {
        return order_p_finame;
    }

    public void setOrder_p_finame(String order_p_finame) {
        this.order_p_finame = order_p_finame;
    }

    public String getOrder_p_name() {
        return order_p_name;
    }

    public void setOrder_p_name(String order_p_name) {
        this.order_p_name = order_p_name;
    }

    public int getOrder_p_price() {
        return order_p_price;
    }

    public void setOrder_p_price(int order_p_price) {
        this.order_p_price = order_p_price;
    }

    public String getOrder_u_id() {
        return order_u_id;
    }

    public void setOrder_u_id(String order_u_id) {
        this.order_u_id = order_u_id;
    }
}
