package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKhuyenMai;
    @NotBlank
    private String tieuDeKhuyenMai;
    @Column(columnDefinition = "date")
    private String thoiGianBatDau;
    @Column(columnDefinition = "date")
    private String thoiGianKetThuc;
    @NotNull
    @Min(10000)
    private Double mucGiamGia;
    @NotBlank
    private String chiTiet;
}
