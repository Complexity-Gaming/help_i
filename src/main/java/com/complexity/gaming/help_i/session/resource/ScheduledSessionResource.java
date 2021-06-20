package com.complexity.gaming.help_i.session.resource;

import com.complexity.gaming.help_i.shared.model.Money;
import com.complexity.gaming.help_i.session.domain.model.ScheSessionId;
import com.complexity.gaming.help_i.session.domain.model.SessionDate;
import com.complexity.gaming.help_i.security.application.transform.resource.ExpertResource;
import com.complexity.gaming.help_i.security.application.transform.resource.PlayerResource;

public class ScheduledSessionResource {

    private Long id;
    private ExpertResource expert;
    private PlayerResource player;
    private Money price;
    private ScheSessionId scheduled;
    private SessionDate sessionDate;

    public Long getId() {
        return id;
    }

    public ScheduledSessionResource setId(Long id) {
        this.id = id;
        return this;
    }

    public ExpertResource getExpert() {
        return expert;
    }

    public ScheduledSessionResource setExpert(ExpertResource expert) {
        this.expert = expert;
        return this;
    }

    public PlayerResource getPlayer() {
        return player;
    }

    public ScheduledSessionResource setPlayer(PlayerResource player) {
        this.player = player;
        return this;
    }

    public Money getPrice() {
        return price;
    }

    public ScheduledSessionResource setPrice(Money price) {
        this.price = price;
        return this;
    }

    public ScheSessionId getScheduled() {
        return scheduled;
    }

    public ScheduledSessionResource setScheduled(ScheSessionId scheduled) {
        this.scheduled = scheduled;
        return this;
    }

    public SessionDate getSessionDate() {
        return sessionDate;
    }

    public ScheduledSessionResource setSessionDate(SessionDate sessionDate) {
        this.sessionDate = sessionDate;
        return this;
    }
}
