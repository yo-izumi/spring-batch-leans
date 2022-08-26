package com.example.open_meteo_download;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenMeteoDownloadApplication {

	public static void main(String[] args) {
		// 待機型(処理終了しない)
		// SpringApplication.run(OpenMeteoDownloadApplication.class, args);
		// 1パス用バッチ実行処理
		System.exit(SpringApplication.exit(SpringApplication.run(OpenMeteoDownloadApplication.class, args)));
	}

}
