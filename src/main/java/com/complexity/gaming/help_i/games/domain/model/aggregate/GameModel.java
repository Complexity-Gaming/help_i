package com.complexity.gaming.help_i.games.domain.model.aggregate;

import com.complexity.gaming.help_i.games.domain.model.valueobjects.ProviderInformation;

import javax.persistence.*;

@Entity
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long providerId;
    @Embedded
    private ProviderInformation providerInformation;
    public GameModel SetProviderInformation(ProviderInformation providerInformation){
        this.providerInformation = providerInformation;
        return this;
    };

    public Long getId() {
        return id;
    }

    public GameModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getProviderId() {
        return providerId;
    }

    public GameModel setProviderId(Long providerId) {
        this.providerId = providerId;
        return this;
    }

    public ProviderInformation getProviderInformation() {
        return providerInformation;
    }
}

