package com.uploader.playerstatscsvuploaderapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RunningBacksAdvancedStats {
    private long id;

    private String name;

    private int year;

    private int age;

    private String team;

    private String position;

    private int teamNumber;

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
}
