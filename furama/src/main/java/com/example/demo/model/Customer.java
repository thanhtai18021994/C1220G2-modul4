package com.example.demo.model;

import com.example.demo.customvalidation.Phone;
import com.example.demo.customvalidation.customer.SameEmail;
import com.example.demo.model.CustomerType;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;
    @Pattern(regexp = "^KH-\\d{4}$",message = "KH-xxxx x là số 0-9")
    private String codeCustomer;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Viet hoa chu cai dau tien !!!")
    private String customerName;
    @Column(columnDefinition = "date")
    private String customerBirthday;
    private String customerGender;
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$",message = "(xxxxxxxxx)|(xxxxxxxxxxxx) x là số 0-9")
    private String customerIdCard;
    @Phone
    private String customerPhone;
    @Email
    private String customerEmail;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Viet hoa chu cai dau tien !!!")
    private String customerAddress;
    @ManyToOne()
    @JoinColumn(name = "customer_type_id")
    CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contract;
}
