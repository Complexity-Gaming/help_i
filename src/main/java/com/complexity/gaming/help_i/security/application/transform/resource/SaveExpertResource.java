package com.complexity.gaming.help_i.security.application.transform.resource;

import javax.validation.constraints.NotNull;

public class SaveExpertResource extends SavePersonResource{
    public Long getGame() {
        return game;
    }

    public SaveExpertResource setGame(Long game) {
        this.game = game;
        return this;
    }

    private Long game;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public SaveExpertResource setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public String getWhyMe() {
        return whyMe;
    }

    public SaveExpertResource setWhyMe(String whyMe) {
        this.whyMe = whyMe;
        return this;
    }

    public String getExperience() {
        return experience;
    }

    public SaveExpertResource setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public SaveExpertResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    private String photoUrl;
    private String whyMe;
    private String experience;
    private String userName;

}
