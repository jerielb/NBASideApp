package com.jerielb.NBASideApp.model;

import org.springframework.stereotype.Component;

@Component
public class Player {
    // variables
    private long playerId;
    private String fullName;
    private String positions;
    private int overall;
    
    private String insideScoring;
    private String midRangeScoring;
    private String threePointScoring;

    private String interiorDefense;
    private String perimeterDefense;
    private String playmaking;

    private String rebounding;
    private String physicals;
    private String iq;

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

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
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

    public String getPhysicals() {
        return physicals;
    }

    public void setPhysicals(String physicals) {
        this.physicals = physicals;
    }

    public String getIq() {
        return iq;
    }

    public void setIq(String iq) {
        this.iq = iq;
    }
}
