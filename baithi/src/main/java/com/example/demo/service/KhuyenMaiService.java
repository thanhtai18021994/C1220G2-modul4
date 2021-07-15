package com.example.demo.service;

import com.example.demo.model.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhuyenMaiService implements IKhuyenMaiService {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Override
    public Page<KhuyenMai> findAll(Pageable pageable) {
        return khuyenMaiRepository.findAll(pageable);
    }

    @Override
    public List<KhuyenMai> findAll() {
        return khuyenMaiRepository.findAll();    }

    @Override
    public void save(KhuyenMai khuyenMai) {
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void delete(KhuyenMai khuyenMai) {
         khuyenMaiRepository.delete(khuyenMai);
    }

    @Override
    public Optional<KhuyenMai> findById(Integer id) {
        return khuyenMaiRepository.findById(id);
    }

    @Override
    public List<KhuyenMai> findByThoiGianBatDau(String ngay) {
        return khuyenMaiRepository.findByThoiGianBatDau(ngay);
    }

    @Override
    public List<KhuyenMai> findByThoiGianKetThuc(String ngay) {
        return khuyenMaiRepository.findByThoiGianKetThuc(ngay);
    }

    @Override
    public List<KhuyenMai> findByMucGiamGia(Double gia) {
        return khuyenMaiRepository.findByMucGiamGia(gia);
    }

    @Override
    public List<KhuyenMai> findAllFiled(Double gia, String ngay1, String ngay2) {
        return khuyenMaiRepository.findByMucGiamGiaAndThoiGianBatDauGreaterThanEqualAndThoiGianKetThucLessThanEqual(gia, ngay1, ngay2);
    }
}
