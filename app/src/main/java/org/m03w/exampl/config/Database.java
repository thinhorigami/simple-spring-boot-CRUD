package org.m03w.exampl.config;

import org.m03w.exampl.entiry.HoaDon;
import org.m03w.exampl.entiry.PhieuGiaoHang;
import org.m03w.exampl.repository.PhieuGiaoHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Database {

    @Autowired
    private PhieuGiaoHangRepository phieuGiaoHangRepository;

    @Bean
    public CommandLineRunner templateData() {
        return args -> {
            if (phieuGiaoHangRepository.findAll().isEmpty()) {

                phieuGiaoHangRepository.saveAll(Arrays.asList(
                    PhieuGiaoHang.builder()
                        .phiGiaoHang(1234.1)
                        .hoaDon(HoaDon.builder()
                            .nguoiLap("user")
                            .build())
                        .build(),
                    PhieuGiaoHang.builder()
                        .phiGiaoHang(1234.1)
                        .hoaDon(HoaDon.builder()
                            .nguoiLap("user")
                            .build())
                        .build()
                ));
            }
        };
    }
}
