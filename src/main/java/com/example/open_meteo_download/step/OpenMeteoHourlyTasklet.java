package com.example.open_meteo_download.step;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.open_meteo_download.response.OpenMeteoResponse;
import com.example.open_meteo_download.service.OpenMeteoHistoryRepositoryService;
import com.example.open_meteo_download.service.OpenMeteoHourlyService;

@Component
public class OpenMeteoHourlyTasklet implements Tasklet {

    @Autowired
    private OpenMeteoHourlyService houryService;

    @Autowired
    private OpenMeteoHistoryRepositoryService historyService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        OpenMeteoResponse.Hourly hourly = historyService.selectHourly();
        if (!ObjectUtils.isEmpty(hourly)) {
            houryService.saveHourly(hourly);
        }
        return RepeatStatus.FINISHED;
    }
    
}
