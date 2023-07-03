package com.uploader.playerstatscsvuploaderapi.repository;

import com.uploader.playerstatscsvuploaderapi.entity.PlayerAdvancedStatsEntity;
import com.uploader.playerstatscsvuploaderapi.model.PlayerAdvancedStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatsRepository extends JpaRepository<PlayerAdvancedStatsEntity, Long> {

}
