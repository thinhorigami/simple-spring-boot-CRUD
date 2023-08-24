package org.m03w.exampl.entiry;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "PhieuGiaoHang")
@Table(name = "PhieuGiaoHang")
public class PhieuGiaoHang {
    @Id
    @GeneratedValue
    @Column(name = "MaPhieuGiao")
    private UUID maPhieuGiaoHang;

    @Column(name = "PhiGiaoHang")
    private Double phiGiaoHang;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "HoaDonGiao")
    private HoaDon hoaDon;
}
