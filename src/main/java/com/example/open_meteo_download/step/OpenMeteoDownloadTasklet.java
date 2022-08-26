package com.example.open_meteo_download.step;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.open_meteo_download.response.OpenMeteoResponse;
import com.example.open_meteo_download.service.OpenMeteoApiService;
import com.example.open_meteo_download.service.OpenMeteoHistoryRepositoryService;

@Component
public class OpenMeteoDownloadTasklet implements Tasklet {

    @Autowired
    private OpenMeteoHistoryRepositoryService repositoryService;

    @Autowired
    private OpenMeteoApiService apiService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        OpenMeteoResponse response = apiService.getOpenMeteo();

        repositoryService.insert(response);
        return RepeatStatus.FINISHED;
    }
    
}
