package com.example.open_meteo_download;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class BatchLauncher {
    private final JobLauncher jobLauncher;
    private final Job openMeteoDownloadJob;
    private final Job timeLogJob;

    private JobParameters params;

    // 日曜日09:00:00に実行
    @Scheduled(cron ="${batchlauncher.cron}")
    public void launchJob() throws JobExecutionException {
        this.params = openMeteoDownloadJob.getJobParametersIncrementer().getNext(this.params);
        this.jobLauncher.run(this.openMeteoDownloadJob, this.params);
    }

    public void timeLogJob() throws JobExecutionException {
        this.params = timeLogJob.getJobParametersIncrementer().getNext(this.params);
        this.jobLauncher.run(this.timeLogJob, this.params);
    }
}
