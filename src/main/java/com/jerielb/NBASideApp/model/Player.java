package com.jerielb.NBASideApp.model;

import org.springframework.stereotype.Component;

@Component
public class Player {
    // variables
    private long playerId;
    private String fullName;
    private String image;
    
    private String layup;
    private String dunk;
    private String insideScoring;
    
    private String midRangeScoring;
    private String threePointScoring;
    private String freeThrow;
    
    private String dribbling;
    private String passing;
    private String offensiveRebounding;
    
    private String defensiveRebounding;
    private String steal;
    private String block;
    
    private boolean drafted;
    
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
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getLayup() {
        return layup;
    }
    
    public void setLayup(String layup) {
        this.layup = layup;
    }
    
    public String getDunk() {
        return dunk;
    }
    
    public void setDunk(String dunk) {
        this.dunk = dunk;
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
    
    public String getFreeThrow() {
        return freeThrow;
    }
    
    public void setFreeThrow(String freeThrow) {
        this.freeThrow = freeThrow;
    }
    
    public String getDribbling() {
        return dribbling;
    }
    
    public void setDribbling(String dribbling) {
        this.dribbling = dribbling;
    }
    
    public String getPassing() {
        return passing;
    }
    
    public void setPassing(String passing) {
        this.passing = passing;
    }
    
    public String getOffensiveRebounding() {
        return offensiveRebounding;
    }
    
    public void setOffensiveRebounding(String offensiveRebounding) {
        this.offensiveRebounding = offensiveRebounding;
    }
    
    public String getDefensiveRebounding() {
        return defensiveRebounding;
    }
    
    public void setDefensiveRebounding(String defensiveRebounding) {
        this.defensiveRebounding = defensiveRebounding;
    }
    
    public String getSteal() {
        return steal;
    }
    
    public void setSteal(String steal) {
        this.steal = steal;
    }
    
    public String getBlock() {
        return block;
    }
    
    public void setBlock(String block) {
        this.block = block;
    }
    
    public boolean getDrafted() {
        return drafted;
    }
    
    public void setDrafted(boolean drafted) {
        this.drafted = drafted;
    }
}
