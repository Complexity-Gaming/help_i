package com.complexity.gaming.help_i.resource.application;

import com.complexity.gaming.help_i.domain.model.application.ApplicationDetail;
import com.complexity.gaming.help_i.domain.model.application.ApplicationId;
import com.complexity.gaming.help_i.resource.security.PlayerResource;

public class ExpertApplicationResource {

    private Long id;
    private PlayerResource player;
    private ApplicationId tittle;
    private ApplicationDetail applicationDetails;

    public Long getId() {
        return id;
    }

    public ExpertApplicationResource setId(Long id) {
        this.id = id;
        return this;
    }

    public ApplicationDetail getApplicationDetails() {
        return applicationDetails;
    }

    public ExpertApplicationResource setApplicationDetails(ApplicationDetail applicationDetails) {
        this.applicationDetails = applicationDetails;
        return this;
    }

    public ApplicationId getTittle() {
        return tittle;
    }

    public ExpertApplicationResource setTittle(ApplicationId tittle) {
        this.tittle = tittle;
        return this;
    }

    public PlayerResource getPlayer() {
        return player;
    }

    public ExpertApplicationResource setPlayer(PlayerResource player) {
        this.player = player;
        return this;
    }
}
