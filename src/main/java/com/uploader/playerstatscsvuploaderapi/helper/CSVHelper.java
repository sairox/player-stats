package com.uploader.playerstatscsvuploaderapi.helper;

import com.uploader.playerstatscsvuploaderapi.model.PlayerAdvancedStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERS = {
            "Name", "Year", "Age", "Tm", "Pos", "No.", "G", "Att", "YdsR", "R1D", "RYBC", "YBC/Att", "RYAC", "YAC/Att",
            "RBrkTkl", "Att/Br", "Tgt", "Rec", "Yds", "1D", "YBC", "YBC/R", "YAC", "YAC/R", "ADOT", "BrkTkl", "Rec/Br",
            "Drop", "Drop%", "Int", "Rat"
    };

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<PlayerAdvancedStats> csvToAdvancedStats(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<PlayerAdvancedStats> advancedStats = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                PlayerAdvancedStats playerAdvancedStats = createPlayerAdvancedStats(csvRecord);
                advancedStats.add(playerAdvancedStats);
            }

            return advancedStats;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    private static PlayerAdvancedStats createPlayerAdvancedStats(CSVRecord csvRecord) {
        PlayerAdvancedStats playerAdvancedStats = new PlayerAdvancedStats();
        playerAdvancedStats.setName(csvRecord.get(HEADERS[0]));

        playerAdvancedStats.setYear(yearPlayed(csvRecord.get(HEADERS[1])));

        playerAdvancedStats.setAge(Integer.parseInt(csvRecord.get(HEADERS[2])));
        playerAdvancedStats.setTeam(csvRecord.get(HEADERS[3]));
        playerAdvancedStats.setPosition(csvRecord.get(HEADERS[4]));
        playerAdvancedStats.setTeamNumber(Integer.parseInt(csvRecord.get(HEADERS[5])));
        playerAdvancedStats.setGamesPlayed(Integer.parseInt(csvRecord.get(HEADERS[6])));

        if(isNotRecordNull(csvRecord, HEADERS[7])) {
            playerAdvancedStats.setRushAttempts(Integer.parseInt(csvRecord.get(HEADERS[7])));
        } else {
            playerAdvancedStats.setRushAttempts(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[8])) {
            playerAdvancedStats.setRushYards(Integer.parseInt(csvRecord.get(HEADERS[8])));
        } else{
            playerAdvancedStats.setRushYards(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[9])) {
            playerAdvancedStats.setFirstDownRushes(Integer.parseInt(csvRecord.get(HEADERS[9])));
        } else{
            playerAdvancedStats.setFirstDownRushes(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[10])) {
            playerAdvancedStats.setYardsBeforeContact(Integer.parseInt(csvRecord.get(HEADERS[10])));
        }  else{
            playerAdvancedStats.setYardsBeforeContact(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[11])) {
            playerAdvancedStats.setRushingYardsBeforeContactPerRushingAttempt(Double.parseDouble(csvRecord.get(HEADERS[11])));
        } else{
            playerAdvancedStats.setRushingYardsBeforeContactPerRushingAttempt(0.0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[12])) {
            playerAdvancedStats.setRushingYardsAfterContact(Integer.parseInt(csvRecord.get(HEADERS[12])));
        } else{
            playerAdvancedStats.setRushingYardsAfterContact(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[13])) {
            playerAdvancedStats.setRushingYardsAfterContactPerRush(Double.parseDouble(csvRecord.get(HEADERS[13])));
        } else{
            playerAdvancedStats.setRushingYardsAfterContactPerRush(0.0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[14])) {
            playerAdvancedStats.setBrokenTacklesRushing(Integer.parseInt(csvRecord.get(HEADERS[14])));
        } else{
            playerAdvancedStats.setBrokenTacklesRushing(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[15])) {
            playerAdvancedStats.setRushAttemptsPerBrokenTackle(Double.parseDouble(csvRecord.get(HEADERS[15])));
        } else{
            playerAdvancedStats.setRushAttemptsPerBrokenTackle(0.0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[16])) {
            playerAdvancedStats.setPassTargets(Integer.parseInt(csvRecord.get(HEADERS[16])));
        } else{
            playerAdvancedStats.setPassTargets(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[17])) {
            playerAdvancedStats.setReceptions(Integer.parseInt(csvRecord.get(HEADERS[17])));
        } else{
            playerAdvancedStats.setReceptions(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[18])) {
            playerAdvancedStats.setReceivingYards(Integer.parseInt(csvRecord.get(HEADERS[18])));
        } else{
            playerAdvancedStats.setReceivingYards(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[19])) {
            playerAdvancedStats.setFirstDownReceiving(Integer.parseInt(csvRecord.get(HEADERS[19])));
        } else{
            playerAdvancedStats.setFirstDownReceiving(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[20])) {
            playerAdvancedStats.setYardsBeforeCatch(Integer.parseInt(csvRecord.get(HEADERS[20])));
        } else{
            playerAdvancedStats.setYardsBeforeCatch(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[21])) {
            playerAdvancedStats.setYardsBeforeCatchPerReception(Double.parseDouble(csvRecord.get(HEADERS[21])));
        } else{
            playerAdvancedStats.setYardsBeforeCatchPerReception(0.0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[22])) {
            playerAdvancedStats.setYardsAfterCatch(Integer.parseInt(csvRecord.get(HEADERS[22])));
        } else{
            playerAdvancedStats.setYardsAfterCatch(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[23])) {
            playerAdvancedStats.setYardsAfterCatchPerReception(Double.parseDouble(csvRecord.get(HEADERS[23])));
        } else{
            playerAdvancedStats.setYardsAfterCatchPerReception(0.0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[24])) {
            playerAdvancedStats.setAdot(Double.parseDouble(csvRecord.get(HEADERS[24])));
        } else{
            playerAdvancedStats.setAdot(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[25])) {
            playerAdvancedStats.setBrokenTackleReceiving(Integer.parseInt(csvRecord.get(HEADERS[25])));
        } else{
            playerAdvancedStats.setBrokenTackleReceiving(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[26])) {
            playerAdvancedStats.setReceptionsPerBrokenTackle(Double.parseDouble(csvRecord.get(HEADERS[26])));
        } else{
            playerAdvancedStats.setReceptionsPerBrokenTackle(0.0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[27])) {
            playerAdvancedStats.setDroppedPasses(Integer.parseInt(csvRecord.get(HEADERS[27])));
        } else{
            playerAdvancedStats.setDroppedPasses(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[28])) {
            playerAdvancedStats.setDroppedPassesPerTargetPercent(Double.parseDouble(csvRecord.get(HEADERS[28])));
        } else{
            playerAdvancedStats.setDroppedPassesPerTargetPercent(0.0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[29])) {
            playerAdvancedStats.setIntsOnPassesTargeted(Integer.parseInt(csvRecord.get(HEADERS[29])));
        } else{
            playerAdvancedStats.setIntsOnPassesTargeted(0);
        }

        if(isNotRecordNull(csvRecord, HEADERS[30])) {
            playerAdvancedStats.setPasserRatingsOnPassesTargeted(Double.parseDouble(csvRecord.get(HEADERS[30])));
        } else{
            playerAdvancedStats.setPasserRatingsOnPassesTargeted(0.0);
        }

        return playerAdvancedStats;
    }

    private static boolean isNotRecordNull(CSVRecord csvRecord, String header) {
        return !csvRecord.get(header).isEmpty();
    }

    private static int yearPlayed(String header){
        StringBuilder sb = new StringBuilder(header);
        int lastCharIndex = header.length() - 1;

        while(sb.charAt(lastCharIndex) == '*' || sb.charAt(lastCharIndex) == '+'){
            sb.deleteCharAt(lastCharIndex);
            lastCharIndex--;
        }

        return Integer.parseInt(sb.toString());
    }

}
