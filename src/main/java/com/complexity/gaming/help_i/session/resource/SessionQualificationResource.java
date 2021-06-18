package com.complexity.gaming.help_i.session.resource;

public class SessionQualificationResource {

    private String comment;
    private Short Qualification;

    public String getComment() {
        return comment;
    }

    public SessionQualificationResource setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Short getQualification() {
        return Qualification;
    }

    public SessionQualificationResource setQualification(Short qualification) {
        Qualification = qualification;
        return this;
    }
}
