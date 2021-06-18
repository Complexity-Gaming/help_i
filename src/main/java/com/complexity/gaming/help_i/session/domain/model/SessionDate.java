package com.complexity.gaming.help_i.session.domain.model;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class SessionDate {

    private Date date;
    private short duration;

    public SessionDate(Date date, short duration) {
        this.date = date;
        this.duration = duration;
    }

    public SessionDate() {
    }

    public Date getDate() {
        return date;
    }

    public short getDuration() {
        return duration;
    }

    private SessionDate setDate(Date date) {
        this.date = date;
        return this;
    }

    private SessionDate setDuration(short duration) {
        this.duration = duration;
        return this;
    }
}
