package com.complexity.gaming.help_i.games.domain.model.aggregate;

import com.complexity.gaming.help_i.games.domain.model.valueobjects.ProviderInformation;
import idgbsdk.model.GameModel;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int providerId;
    private String name;
    @Transient
    private ProviderInformation providerInformation;
    public Game setProviderInformation(GameModel model){
        this.providerInformation = new ProviderInformation(model);
        return this;
    }
    public Long getId() {
        return id;
    }

    public Game setId(Long id) {
        this.id = id;
        return this;
    }

    public int getProviderId() {
        return providerId;
    }

    public Game setProviderId(int providerId) {
        this.providerId = providerId;
        return this;
    }

    public ProviderInformation getProviderInformation() {
        return providerInformation;
    }

    public String getName() {
        return name;
    }

    public Game setName(String name) {
        this.name = name;
        return this;
    }
}

