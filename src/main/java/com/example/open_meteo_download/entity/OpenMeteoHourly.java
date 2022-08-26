package com.example.open_meteo_download.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "open_meteo_hourly")
@AllArgsConstructor
@NoArgsConstructor
public class OpenMeteoHourly {
    @Id
    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "shortwave_radiation")
    private Double shortwaveRadiation;
}
