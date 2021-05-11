package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "cartList")
    private List<Product> productList;

    public Cart() {
    }

    public Cart(String name) {
        this.name = name;
    }

    public Cart(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cart(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }

    public Cart(Integer id, String name, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.productList = productList;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
