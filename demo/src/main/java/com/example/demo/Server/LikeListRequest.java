package com.example.demo.Server;

public class LikeListRequest {
    private String productname;
    private String account;
    private int ordername;

    public String getproductname() {
        return productname;
    }

    public void setproductname(String productname) {
        this.productname = productname;
    }

    public String getaccount() {
        return account;
    }

    public void setaccount(String account) {
        this.account = account;
    }

    public int getordername() {
        return ordername;
    }

    public void setordername(int ordername) {
        this.ordername = ordername;
    }
}

