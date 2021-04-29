package com.codegym.repository;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static List<String> listCountry;
    private static List<Integer> listSize;

    static {
        listCountry = new ArrayList<>();
        listCountry.add("Vietnam");
        listCountry.add("Japanese");
        listCountry.add("chinese");
        listCountry.add("English");
        listSize=new ArrayList<>();
        listSize.add(5);
        listSize.add(10);
        listSize.add(15);
        listSize.add(20);
        listSize.add(50);
        listSize.add(100);
    }
    public static List<String> getCountry(){
        return listCountry;
    }
    public static List<Integer> getListSize(){
        return listSize;
    }
}
