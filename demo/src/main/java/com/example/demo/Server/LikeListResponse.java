package com.example.demo.Server;

public class LikeListResponse {
    private long sn;
    private String productname;
    private String account;
    private int totalfee;
    private int totalamount;
    private String email;

    public LikeListResponse(long sn, String productname, String account, int totalfee, int totalamount) {
        this.sn = sn;
        this.productname = productname;
        this.account = account;
        this.totalfee = totalfee;
        this.totalamount = totalamount;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    public long getsn() {
        return sn;
    }

    public void setsn(long sn) {
        this.sn = sn;
    }

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

    public int gettotalfee() {
        return totalfee;
    }

    public void settotalfee(int totalfee) {
        this.totalfee = totalfee;
    }

    public int gettotalamount() {
        return totalamount;
    }

    public void settotalamount(int totalamount) {
        this.totalamount = totalamount;
    }
}





