package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.repository.StudentRepositoryImplement;

import java.util.List;

public class StudentServiceImplement implements StudentService{
    StudentRepository studentRepository=new StudentRepositoryImplement();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
         studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }
}
