package com.example.demo.service;

import com.example.demo.model.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IKhuyenMaiService {
    Page<KhuyenMai> findAll(Pageable pageable);
    List<KhuyenMai> findAll();
    void save(KhuyenMai khuyenMai);
    void delete(KhuyenMai khuyenMai);
    Optional<KhuyenMai> findById(Integer id);
    List<KhuyenMai> findByThoiGianBatDau(String ngay);
    List<KhuyenMai> findByThoiGianKetThuc(String ngay);
    List<KhuyenMai> findByMucGiamGia(Double gia);
    List<KhuyenMai> findAllFiled(Double gia,String ngay1,String ngay2);
}
