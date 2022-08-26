package com.example.open_meteo_download.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.open_meteo_download.entity.OpenMeteoHourly;
import com.example.open_meteo_download.repository.OpenMeteoHourlyRepository;
import com.example.open_meteo_download.response.OpenMeteoResponse;

@Service
public class OpenMeteoHourlyService {
    @Autowired
    private OpenMeteoHourlyRepository hourlyRepository;

    public void saveHourly(OpenMeteoResponse.Hourly hourly) {
        List<OpenMeteoHourly> hourlys = new ArrayList<>();

        List<String> times = hourly.getTime();
        List<Double> temps = hourly.getTemperature2m();
        List<Double> shortwaves = hourly.getShortwaveRadiation();

        for (int index = 0; index < times.size(); index++) {
            hourlys.add(
                    new OpenMeteoHourly(LocalDateTime.parse(times.get(index)), temps.get(index), shortwaves.get(index)));
        }
        hourlyRepository.saveAll(hourlys);
    }
}
