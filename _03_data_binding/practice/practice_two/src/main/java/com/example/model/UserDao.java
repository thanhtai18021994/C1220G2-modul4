package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList;
    static {
        userList=new ArrayList<>();
        User u1=new User("tai","12345","bui thanh tai","taibui18021994@gmail.com",20);
        userList.add(u1);
        User u2=new User("huy","1111","Nguyen huy","huynguyen1992@gmail.com",20);
        userList.add(u2);
        User u3=new User("cong","2222","Thanh cong","congthanh@gmail.com",30);
    }
    public static User checkLogin(Login login){
        for (User u:userList){
            if(u.getAcount().equals(login.getName())&&u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
