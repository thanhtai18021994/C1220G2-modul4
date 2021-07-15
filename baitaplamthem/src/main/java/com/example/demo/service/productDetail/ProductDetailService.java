package com.example.demo.service.productDetail;

import com.example.demo.model.ProductDetail;
import com.example.demo.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailService implements IProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Override
    public Page<ProductDetail> findAll(Pageable pageable) {
        return productDetailRepository.findAll(pageable);
    }

    @Override
    public List<ProductDetail> findAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public void save(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public void delete(ProductDetail productDetail) {
        productDetailRepository.delete(productDetail);
    }

    @Override
    public Optional<ProductDetail> findById(Integer id) {
        return productDetailRepository.findById(id);
    }
}
