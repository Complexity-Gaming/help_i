package com.complexity.gaming.help_i.session.domain.model;

import com.complexity.gaming.help_i.security.domain.model.Expert;
import com.complexity.gaming.help_i.security.domain.model.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "individualSessions")
public class IndividualSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "expert_id", nullable = false)
    @JsonIgnore
    private Expert expert;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    @JsonIgnore
    private Player player;


    public IndividualSession() {
    }

    public IndividualSession(Expert expert, Player player) {
        this.expert = expert;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public IndividualSession setId(Long id) {
        this.id = id;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public IndividualSession setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public IndividualSession setPlayer(Player player) {
        this.player = player;
        return this;
    }
}
