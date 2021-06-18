package com.complexity.gaming.help_i.session.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class SessionQualification {

    private String comment;
    private short qualification;


    public SessionQualification(String comment, short qualification) {
        this.comment = comment;
        this.qualification = qualification;
    }

    public SessionQualification() {
    }

    public String getComment() {
        return comment;
    }

    public short getQualification() {
        return qualification;
    }

    private SessionQualification setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public SessionQualification setQualification(short qualification) {
        this.qualification = qualification;
        return this;
    }
}
