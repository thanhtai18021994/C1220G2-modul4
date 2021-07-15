package com.example.demo.repository;

import com.example.demo.model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai,Integer> {
    List<KhuyenMai> findByThoiGianKetThuc(String text);
    List<KhuyenMai> findByThoiGianBatDau(String text);
    List<KhuyenMai> findByMucGiamGia(Double number);
    List<KhuyenMai> findByMucGiamGiaAndThoiGianBatDauGreaterThanAndThoiGianKetThucLessThan(Double giamgia,String ngaybatdau,String ngayketthuc);
    List<KhuyenMai> findByMucGiamGiaAndThoiGianBatDauGreaterThanEqualAndThoiGianKetThucLessThanEqual(Double giamgia,String ngaybatdau,String ngayketthuc);

}
