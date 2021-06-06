package com.complexity.gaming.help_i.resource.session;

import com.complexity.gaming.help_i.domain.model.Money;
import com.complexity.gaming.help_i.domain.model.session.ScheSessionId;
import com.complexity.gaming.help_i.domain.model.session.SessionDate;

public class SaveScheduledSessionResource {

    private Money price;
    private ScheSessionId scheduled;
    private SessionDate sessionDate;

    public Money getPrice() {
        return price;
    }

    public SaveScheduledSessionResource setPrice(Money price) {
        this.price = price;
        return this;
    }

    public ScheSessionId getScheduled() {
        return scheduled;
    }

    public SaveScheduledSessionResource setScheduled(ScheSessionId scheduled) {
        this.scheduled = scheduled;
        return this;
    }

    public SessionDate getSessionDate() {
        return sessionDate;
    }

    public SaveScheduledSessionResource setSessionDate(SessionDate sessionDate) {
        this.sessionDate = sessionDate;
        return this;
    }
}
