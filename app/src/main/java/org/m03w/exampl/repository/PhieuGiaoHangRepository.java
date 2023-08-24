package org.m03w.exampl.repository;

import org.m03w.exampl.entiry.PhieuGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhieuGiaoHangRepository extends JpaRepository<PhieuGiaoHang, UUID> {
}
