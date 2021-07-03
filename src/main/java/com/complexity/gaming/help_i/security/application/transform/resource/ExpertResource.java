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
}
