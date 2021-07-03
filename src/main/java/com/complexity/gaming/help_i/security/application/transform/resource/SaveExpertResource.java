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

}
