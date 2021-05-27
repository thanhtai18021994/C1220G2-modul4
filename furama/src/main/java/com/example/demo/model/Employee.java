package com.example.demo.model;

import com.example.demo.customvalidation.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Pattern(regexp = "^NV-\\d{4}$",message = "NV-xxxx x là số 0-9")
    private String codeEmployee;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Viet hoa chu cai dau tien !!!")
    private String employeeName;
    private String employeeGender;
    private String employeeBirthday;
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$",message = "(xxxxxxxxx)|(xxxxxxxxxxxx) x là số 0-9")
    private String employeeIdCard;
    private String employeeSalary;
    @Phone
    private String employeePhone;
    @Email(message = "email không đúng định dạng")
    private String employeeEmail;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Viet hoa chu cai dau tien !!!")
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_id")
    private EducationDegree educationDegree;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<Contract> contracts;

}
