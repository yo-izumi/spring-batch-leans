package com.example.open_meteo_download.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.open_meteo_download.entity.OpenMeteoHistory;
import com.example.open_meteo_download.repository.OpenMeteoHistoryRepository;
import com.example.open_meteo_download.response.OpenMeteoResponse;

@Service
public class OpenMeteoHistoryRepositoryService {
    @Autowired
    private OpenMeteoHistoryRepository historyRepository;

    /**
     * データセーブ
     * 
     * @param response
     */
    public void insert(OpenMeteoResponse response) {
        Long id = Optional.ofNullable(historyRepository.getMaxId()).orElse(0L);
        OpenMeteoHistory entity = new OpenMeteoHistory(id + 1L, response);
        historyRepository.save(entity);
    }

    /**
     * 最新の日時データを取得
     * 
     * @return 最新の日時データ
     */
    public OpenMeteoResponse.Hourly selectHourly() {
        OpenMeteoHistory hist = historyRepository.selectLastData();
        return hist.getResponse().getHourly();
    }
}
