package com.complexity.gaming.help_i.session.domain.model;

import javax.validation.constraints.NotNull;

public class ScheSessionId {

    private String scheSessionId;

    public ScheSessionId(String scheSessionId) {
        this.scheSessionId = scheSessionId;
    }

    public ScheSessionId() {
    }

    public String getScheSessionId() {
        return scheSessionId;
    }

    @Override
    public @NotNull String toString(){
        return scheSessionId;
    }

    @Override
    public int hashCode(){
        return scheSessionId.hashCode();
    }
}
