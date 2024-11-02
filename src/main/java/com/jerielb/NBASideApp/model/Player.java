package com.jerielb.NBASideApp.model;

import org.springframework.stereotype.Component;

@Component
public class Player {
    // variables
    private long playerId;
    private String fullName;
    private String positions;
    private String overall;
    
    private String insideScoring;
    private String midRangeScoring;
    private String threePointScoring;
    
    private String playmaking;
    private String rebounding;
    
    private String interiorDefense;
    private String perimeterDefense;
    
    // constructor
    public Player() {}

    // getters & setters
    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getOverall() {
        return overall;
    }

    public void setOverall(String overall) {
        this.overall = overall;
    }

    public String getInsideScoring() {
        return insideScoring;
    }

    public void setInsideScoring(String insideScoring) {
        this.insideScoring = insideScoring;
    }

    public String getMidRangeScoring() {
        return midRangeScoring;
    }

    public void setMidRangeScoring(String midRangeScoring) {
        this.midRangeScoring = midRangeScoring;
    }

    public String getThreePointScoring() {
        return threePointScoring;
    }

    public void setThreePointScoring(String threePointScoring) {
        this.threePointScoring = threePointScoring;
    }
    
    public String getPlaymaking() {
        return playmaking;
    }

    public void setPlaymaking(String playmaking) {
        this.playmaking = playmaking;
    }

    public String getRebounding() {
        return rebounding;
    }

    public void setRebounding(String rebounding) {
        this.rebounding = rebounding;
    }
    
    public String getInteriorDefense() {
        return interiorDefense;
    }
    
    public void setInteriorDefense(String interiorDefense) {
        this.interiorDefense = interiorDefense;
    }
    
    public String getPerimeterDefense() {
        return perimeterDefense;
    }
    
    public void setPerimeterDefense(String perimeterDefense) {
        this.perimeterDefense = perimeterDefense;
    }
}
