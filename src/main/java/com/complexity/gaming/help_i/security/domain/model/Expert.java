package com.complexity.gaming.help_i.security.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "experts")
public class Expert extends Person {

    public Expert(@NotNull @Size(max = 100) String name, @NotNull @Size(max = 100) String email, @NotNull Date birthDate, @NotNull String password, Long game) {
        super(name, email, birthDate, password);
        this.game = game;
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
}
