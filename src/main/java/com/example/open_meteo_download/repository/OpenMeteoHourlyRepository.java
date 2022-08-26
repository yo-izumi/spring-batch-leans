package com.example.open_meteo_download.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.open_meteo_download.entity.OpenMeteoHourly;

@Repository
public interface OpenMeteoHourlyRepository extends JpaRepository<OpenMeteoHourly, LocalDateTime> {

}
