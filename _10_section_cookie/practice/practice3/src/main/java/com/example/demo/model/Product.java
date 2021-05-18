package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameProduct;
    private String msp;
    private Double oldPrice;
    private Double newPrice;
    private String description;

    public Product() {
    }

    public Product(String nameProduct, String msp, Double oldPrice, Double newPrice,String description) {
        this.nameProduct = nameProduct;
        this.msp = msp;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.description=description;
    }

    public Product(Integer id, String nameProduct, String msp, Double oldPrice, Double newPrice,String description) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.msp = msp;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.description=description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getMsp() {
        return msp;
    }

    public void setMsp(String msp) {
        this.msp = msp;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(msp, product.msp) &&
                Objects.equals(oldPrice, product.oldPrice) &&
                Objects.equals(newPrice, product.newPrice) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct, msp, oldPrice, newPrice, description);
    }
}
