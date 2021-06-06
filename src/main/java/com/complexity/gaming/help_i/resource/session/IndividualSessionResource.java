package com.complexity.gaming.help_i.resource.session;

import com.complexity.gaming.help_i.resource.security.ExpertResource;
import com.complexity.gaming.help_i.resource.security.PlayerResource;

public class IndividualSessionResource {

    private Long id;
    private PlayerResource player;
    private ExpertResource expert;

    public Long getId() {
        return id;
    }

    public IndividualSessionResource setId(Long id) {
        this.id = id;
        return this;
    }

    public PlayerResource getPlayer() {
        return player;
    }

    public IndividualSessionResource setPlayer(PlayerResource player) {
        this.player = player;
        return this;
    }

    public ExpertResource getExpert() {
        return expert;
    }

    public IndividualSessionResource setExpert(ExpertResource expert) {
        this.expert = expert;
        return this;
    }
}
