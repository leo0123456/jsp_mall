package com.lmonkey.entity;

public class LMONKEY_PRODUCT {
    private int PRODUCT_ID;
    private String PRODUCT_NAME;
    private String PRODUCT_DESCRIPTION;
    private int PRODUCT_PRICE;
    private int PRODUCT_FID;
    private int PRODUCT_CID;
    private String PRODUCT_FILENAME;
    private String PRODUCT_FINAME;
    public LMONKEY_PRODUCT(int pRODUCT_ID, String pRODUCT_NAME,
                           String pRODUCT_DESCRIPTION, int pRODUCT_PRICE,
                           int pRODUCT_FID, int pRODUCT_CID, String pRODUCT_FILENAME,String pRODUCT_FINAME) {
        super();
        PRODUCT_ID = pRODUCT_ID;
        PRODUCT_NAME = pRODUCT_NAME;
        PRODUCT_DESCRIPTION = pRODUCT_DESCRIPTION;
        PRODUCT_PRICE = pRODUCT_PRICE;
        PRODUCT_FID = pRODUCT_FID;
        PRODUCT_CID = pRODUCT_CID;
        PRODUCT_FILENAME = pRODUCT_FILENAME;
        PRODUCT_FINAME = pRODUCT_FINAME;
    }
    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }
    public void setPRODUCT_ID(int pRODUCT_ID) {
        PRODUCT_ID = pRODUCT_ID;
    }
    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }
    public void setPRODUCT_NAME(String pRODUCT_NAME) {
        PRODUCT_NAME = pRODUCT_NAME;
    }
    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }
    public void setPRODUCT_DESCRIPTION(String pRODUCT_DESCRIPTION) {
        PRODUCT_DESCRIPTION = pRODUCT_DESCRIPTION;
    }
    public int getPRODUCT_PRICE() {
        return PRODUCT_PRICE;
    }
    public void setPRODUCT_PRICE(int pRODUCT_PRICE) {
        PRODUCT_PRICE = pRODUCT_PRICE;
    }

    public int getPRODUCT_FID() {
        return PRODUCT_FID;
    }
    public void setPRODUCT_FID(int pRODUCT_FID) {
        PRODUCT_FID = pRODUCT_FID;
    }
    public int getPRODUCT_CID() {
        return PRODUCT_CID;
    }
    public void setPRODUCT_CID(int pRODUCT_CID) {
        PRODUCT_CID = pRODUCT_CID;
    }
    public String getPRODUCT_FILENAME() {
        return PRODUCT_FILENAME;
    }
    public void setPRODUCT_FILENAME(String pRODUCT_FILENAME) {
        PRODUCT_FILENAME = pRODUCT_FILENAME;
    }
    public String getPRODUCT_FINAME() {
        return PRODUCT_FINAME;
    }
    public void setPRODUCT_FINAME(String pRODUCT_FINAME) {
        PRODUCT_FILENAME = pRODUCT_FINAME;
    }



}
