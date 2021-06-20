package com.complexity.gaming.help_i.session.domain.model;

import com.complexity.gaming.help_i.shared.model.Money;
import com.complexity.gaming.help_i.security.domain.model.Expert;
import com.complexity.gaming.help_i.security.domain.model.Player;
import com.complexity.gaming.help_i.session.domain.model.converters.ScheSessionIdAttributeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ScheduledSessions")
public class ScheduledSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Money price;

    @Convert(converter = ScheSessionIdAttributeConverter.class)
    private ScheSessionId scheduled;

    @Embedded
    private SessionDate sessionDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "expert_id", nullable = false)
    @JsonIgnore
    private Expert expert;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    @JsonIgnore
    private Player player;

    public ScheduledSession() {
    }

    public ScheduledSession(Money price, ScheSessionId scheduled, SessionDate sessionDate, Expert expert, Player player) {
        this.price = price;
        this.scheduled = scheduled;
        this.sessionDate = sessionDate;
        this.expert = expert;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public ScheduledSession setId(Long id) {
        this.id = id;
        return this;
    }

    public Money getPrice() {
        return price;
    }

    public ScheduledSession setPrice(Money price) {
        this.price = price;
        return this;
    }

    public ScheSessionId getScheduled() {
        return scheduled;
    }

    public ScheduledSession setScheduled(ScheSessionId scheduled) {
        this.scheduled = scheduled;
        return this;
    }

    public SessionDate getSessionDate() {
        return sessionDate;
    }

    public ScheduledSession setSessionDate(SessionDate sessionDate) {
        this.sessionDate = sessionDate;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public ScheduledSession setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public ScheduledSession setPlayer(Player player) {
        this.player = player;
        return this;
    }
}
