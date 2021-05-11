package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String color;
    private Double price;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "id_category",nullable = false,referencedColumnName = "id_category")
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product_detail",nullable = false)
    private ProductDetail productDetail;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_product",joinColumns = @JoinColumn(name = "id_cart"),inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Cart> cartList;

    public Product() {
    }

    public Product(String name, String color, Double price, Integer amount) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.amount = amount;
    }

    public Product(Integer id, String name, String color, Double price, Integer amount, Category category, ProductDetail productDetail, List<Cart> cartList) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.productDetail = productDetail;
        this.cartList = cartList;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
