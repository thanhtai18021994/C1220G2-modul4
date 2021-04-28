package com.springmvc.service;

public class Caculator {
    public double phepCong(double a,double b){
        return a+b;
    }
    public double phepTru(double a,double b){
        return a-b;
    }
    public String phepChia(double a,double b){
        String result=null;
        if(b==0){
            result="Math error";
        }else {
            result=a/b+"";
        }
        return result;
    }
    public double phepNhan(double a,double b){
        return a*b;
    }

}
