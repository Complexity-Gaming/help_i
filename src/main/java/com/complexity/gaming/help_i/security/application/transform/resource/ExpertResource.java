package com.complexity.gaming.help_i.security.application.transform.resource;

public class ExpertResource extends PersonResource{
    public Long getGame() {
        return game;
    }

    public ExpertResource setGame(Long game) {
        this.game = game;
        return this;
    }
    private Long game;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public ExpertResource setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public String getWhyMe() {
        return whyMe;
    }

    public ExpertResource setWhyMe(String whyMe) {
        this.whyMe = whyMe;
        return this;
    }

    public String getExperience() {
        return experience;
    }

    public ExpertResource setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ExpertResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    private String photoUrl;
    private String whyMe;
    private String experience;
    private String userName;
}
