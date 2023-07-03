package com.uploader.playerstatscsvuploaderapi.service;

import com.uploader.playerstatscsvuploaderapi.entity.PlayerAdvancedStatsEntity;
import com.uploader.playerstatscsvuploaderapi.helper.CSVHelper;
import com.uploader.playerstatscsvuploaderapi.model.PlayerAdvancedStats;
import com.uploader.playerstatscsvuploaderapi.repository.PlayerStatsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {
    @Autowired
    PlayerStatsRepository playerStatsRepository;

    public void saveCsv(MultipartFile file){
        try{
            List<PlayerAdvancedStats> playerAdvancedStats = CSVHelper.csvToAdvancedStats(file.getInputStream());

            for(PlayerAdvancedStats stats : playerAdvancedStats){
                PlayerAdvancedStatsEntity playerAdvancedStatsEntity = new PlayerAdvancedStatsEntity();
                BeanUtils.copyProperties(stats, playerAdvancedStatsEntity);
                playerStatsRepository.save(playerAdvancedStatsEntity);
            }

        } catch (IOException e) {
            throw new RuntimeException("fail to store csv" + e.getMessage());
        }
    }

    public List<PlayerAdvancedStats> getAllAdvancedStats(){
        List<PlayerAdvancedStatsEntity> playerAdvancedStatsEntities = playerStatsRepository.findAll();
        List<PlayerAdvancedStats> advancedStats = new ArrayList<>();

        for(PlayerAdvancedStatsEntity entity : playerAdvancedStatsEntities){
            PlayerAdvancedStats stats = new PlayerAdvancedStats();
            BeanUtils.copyProperties(entity, stats);

            advancedStats.add(stats);
        }

        return advancedStats;
    }
}
