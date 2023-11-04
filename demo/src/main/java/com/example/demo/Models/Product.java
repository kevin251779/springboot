package com.example.demo.Models;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    @Column
    private String productname;
    @Column
    private int price;
    @Column
    private double feerate;

    public long getNo() {
        return no;
    }
    public void setno(long no) {
        this.no = no;
    }

    public String getproductname() {
        return productname;
    }

    public void setproductname(String productname) {
        this.productname = productname;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }

    public double getfeerate() {
        return feerate;
    }

    public void setfeerate(double feerate) {
        this.feerate = feerate;
    }


}
