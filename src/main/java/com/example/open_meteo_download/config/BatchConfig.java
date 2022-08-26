package com.example.open_meteo_download.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.open_meteo_download.step.OpenMeteoDownloadTasklet;
import com.example.open_meteo_download.step.OpenMeteoHourlyTasklet;

import lombok.AllArgsConstructor;

@EnableBatchProcessing
@Configuration
@AllArgsConstructor
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final OpenMeteoDownloadTasklet openMeteoDownloadTasklet;
    private final OpenMeteoHourlyTasklet openMeteoHourlyTasklet;

    @Bean
    public Job openMeteoDownloadJob(Step openMeteoDownloadStep, Step openMeteoHourlyStep) {
        // 1つのTaskletのみ
        // return jobBuilderFactory.get("openMeteoDownloadJob")
        // .flow(openMeteoDownloadStep).end().build();
        return jobBuilderFactory.get("openMeteoDownloadJob").incrementer(new RunIdIncrementer())
                .start(openMeteoDownloadStep).next(openMeteoHourlyStep).build();
    }

    @Bean
    public Step openMeteoDownloadStep() {
        return stepBuilderFactory.get("openMeteoDownloadStep")
                .tasklet(openMeteoDownloadTasklet).build();
    }

    @Bean
    public Step openMeteoHourlyStep() {
        return stepBuilderFactory.get("openMeteoHourlyStep")
                .tasklet(openMeteoHourlyTasklet).build();
    }
}
