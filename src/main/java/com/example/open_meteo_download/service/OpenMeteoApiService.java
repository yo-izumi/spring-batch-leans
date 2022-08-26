package com.example.open_meteo_download.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.open_meteo_download.response.OpenMeteoResponse;

@Service
public class OpenMeteoApiService {
    @Value("${openmeteo.url}")
    private String url;

    /**
     * OpenMeteoAPI実行
     * 
     * @return レスポンスjson
     */
    public OpenMeteoResponse getOpenMeteo() {
        // リクエストの送信
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OpenMeteoResponse> response = restTemplate.exchange(url, HttpMethod.GET, null, OpenMeteoResponse.class);

        // 結果の取得
        return response.getBody();
    }
}
