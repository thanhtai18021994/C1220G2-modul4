package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_detail")
    private Integer id;
    private String image;
    private String discription;


    @OneToOne(mappedBy = "productDetail")
    private Product product;

    public ProductDetail() {
    }

    public ProductDetail(String image, String discription) {
        this.image = image;
        this.discription = discription;
    }

    public ProductDetail(String image, String discription, Product product) {
        this.image = image;
        this.discription = discription;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
