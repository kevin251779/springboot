package com.example.demo.Models;

import javax.persistence.*;

@Entity
public class LikeList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sn;
    @Column
    private int ordername;
    @Column
    private String account;
    @Column
    private int totalfee;
    @Column
    private int totalamount;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    public long getsn() {
        return sn;
    }
    public void setsn(long sn) {
        this.sn = sn;
    }
    public int getordername() {
        return ordername;
    }
    public void setordername(int ordername) {
        this.ordername = ordername;
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
    public Product getproduct() {
        return product;
    }
    public void setproduct(Product product) {
        this.product = product;
    }






}
