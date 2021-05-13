package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;


public class MyCount {
    private int acount;

    public MyCount() {
    }

    public MyCount(Integer acount) {
        this.acount = acount;
    }

    public Integer getAcount() {
        return acount;
    }

    public void setAcount(Integer acount) {
        this.acount = acount;
    }
    public Integer increment(){
        return acount++;
    }
}
