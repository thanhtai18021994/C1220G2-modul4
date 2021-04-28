package com.example.repository;

import com.example.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImplement implements StudentRepository {
    private static Map<Integer,Student> studentMap;
    static {
        studentMap=new HashMap<>();
        studentMap.put(1,new Student(1,"Bui Thanh Tai","Hoa Khanh"));
        studentMap.put(2,new Student(2,"Bui Thanh Cong","Hoa Minh"));
        studentMap.put(3,new Student(3,"Bui Thanh Hieu","Hoa Cuong"));
        studentMap.put(4,new Student(4,"Bui Thanh Dat","Hoa Hiep"));
    }
    @Override
    public List<Student> findAll() {
        List<Student> studentList=new ArrayList<>(studentMap.values());
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return studentMap.get(id);
    }

    @Override
    public void save(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void delete(int id) {
        studentMap.remove(id);
    }
}
