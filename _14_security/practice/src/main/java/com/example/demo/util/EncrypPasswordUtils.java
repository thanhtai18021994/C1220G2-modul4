package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrypPasswordUtils {
    public static String EncrypPasswordUtils(String password){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    public static Boolean ParseEncrip(String password,String currentPassword){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return encoder.matches(currentPassword,password);
    }
}
