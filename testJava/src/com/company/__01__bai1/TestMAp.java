package com.company.__01__bai1;

import java.util.Map;
import java.util.TreeMap;

public class TestMAp {
    public static void addObject(Map<String,Integer> map, String text){
        Integer count=map.containsKey(text)?map.get(text):0;
        map.put(text,count+1);
    }
    public static void main(String[] args) {
        Map<String,Integer> map=new TreeMap<>();
        map.put("a",1);
        TestMAp.addObject(map,"a");
        TestMAp.addObject(map,"a");
        TestMAp.addObject(map,"b");
        System.out.println(map);
    }
}
