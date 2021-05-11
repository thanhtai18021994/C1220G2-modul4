package com.example.demo.model;

import com.example.demo.customvalidation.Age;
import com.example.demo.customvalidation.Name;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    @Size(min = 3,max = 20)

    @Name
    private String name;

    @Age
    private Integer age;

    public User() {
    }

    public User(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(Integer id, String name,Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        User user = (User) target;
//        String name = user.getName();
//        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
//        if (!(name.length() > 3 && name.length() < 45)) {
//            errors.rejectValue("name", "name.length");
//        } else if (!name.matches("^[A-Z][a-zA-Z ]*$")) {
//            errors.rejectValue("name", "name.letter");
//        }
//        String age = user.getAge() + "";
//        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
//        if (!(age.matches("^[0-9]{1,3}$"))) {
//            errors.rejectValue("age", "age.number");
//        }
//        if (!(Integer.parseInt(age) >= 18 && Integer.parseInt(age) <= 100)) {
//            errors.rejectValue("age", "age.size");
//        }
//    }
}
