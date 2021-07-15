package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idProduct;
    private String nameProduct;
    private String factoryProduct;
    private Double priceProduct;
    private Double discount;
    private Integer warehouse;
    private Integer sold;
    private String imageProduct;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToOne(mappedBy = "product")
    private ProductDetail productDetail;

    public Double countProduct(){
        return this.priceProduct*discount/100;
    }
    public void sell(Integer number){
        sold=sold+number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idProduct, product.idProduct) &&
                Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(factoryProduct, product.factoryProduct) &&
                Objects.equals(priceProduct, product.priceProduct) &&
                Objects.equals(discount, product.discount) &&
                Objects.equals(warehouse, product.warehouse) &&
                Objects.equals(sold, product.sold) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, nameProduct, factoryProduct, priceProduct, discount, warehouse, sold, category);
    }
}
