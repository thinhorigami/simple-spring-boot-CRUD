package org.m03w.exampl.controller;

import lombok.*;
import org.m03w.exampl.entiry.PhieuGiaoHang;
import org.m03w.exampl.repository.PhieuGiaoHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@RestController
public class PhieuGiaoHangController {

    @Autowired
    private PhieuGiaoHangRepository phieuGiaoHangRepository;

    @GetMapping("/all")
    public List<PhieuGiaoHang> all() {
        return this.phieuGiaoHangRepository.findAll(PageRequest.ofSize(5))
            .stream()
            .toList();
    }
}
