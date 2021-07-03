package com.complexity.gaming.help_i.security.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "experts")
public class Expert extends Person {


    private String photoUrl;
    private String whyMe;
    private String experience;
    private String userName;

    public Expert(@NotNull @Size(max = 100) String name, @NotNull @Size(max = 100) String email,
                  @NotNull Date birthDate, @NotNull String password, Long game, @NotNull String photoUrl,
                  @NotNull String whyMe, @NotNull String experience, @NotNull String userName) {
        super(name, email, birthDate, password);
        this.game = game;
        this.photoUrl = photoUrl;
        this.whyMe = whyMe;
        this.userName = userName;
        this.experience = experience;
    }
    public Long getGame() {
        return game;
    }

    public Expert setGame(Long game) {
        this.game = game;
        return this;
    }

    private Long game;

    public Expert() {
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Expert setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public String getWhyMe() {
        return whyMe;
    }

    public Expert setWhyMe(String whyMe) {
        this.whyMe = whyMe;
        return this;
    }

    public String getExperience() {
        return experience;
    }

    public Expert setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Expert setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
