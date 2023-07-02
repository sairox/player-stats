package com.uploader.playerstatscsvuploaderapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wide_receivers_advanced_stats")
public class WideRecieverAdvancedStatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int year;

    private int age;

    private String team;

    private String position;

    private int teamNumber;

    private int gamesPlayed;

    private int passTargets;

    private int receptions;

    private int receivingYards;

    private int firstDownReceiving;

    private int totalYdsTrvInAirBeforeCatch;

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

    private int rushAttempts;

    private int rushYards;

    private int firstDownRushes;

    private int yardsBeforeContact;

    private double rushingYardsBeforeContactPerRushingAttempt;

    private int rushingYardsAfterContact;

    private double rushingYardsAfterContactPerRush;

    private int brokenTacklesRushing;

    private double rushAttemptsPerBrokenTackle;
}
