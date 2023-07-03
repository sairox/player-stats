package com.uploader.playerstatscsvuploaderapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "player_adavanced_stats")
public class PlayerAdvancedStatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String team;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private int teamNumber;

    @Column(nullable = false)
    private int gamesPlayed;

    private int rushAttempts;

    private int rushYards;

    private int firstDownRushes;

    private int yardsBeforeContact;

    private double rushingYardsBeforeContactPerRushingAttempt;

    private int rushingYardsAfterContact;

    private double rushingYardsAfterContactPerRush;

    private int brokenTacklesRushing;

    private double rushAttemptsPerBrokenTackle;

    private int passTargets;

    private int receptions;

    private int receivingYards;

    private int firstDownReceiving;

    private int yardsBeforeCatch;

    private double yardsBeforeCatchPerReception;

    private int yardsAfterCatch;

    private double yardsAfterCatchPerReception;

    private double adot;

    private int brokenTackleReceiving;

    private double receptionsPerBrokenTackle;

    private int droppedPasses;

    private double droppedPassesPerTargetPercent;

    private int intsOnPassesTargeted;

    private double passerRatingsOnPassesTargeted;
}
