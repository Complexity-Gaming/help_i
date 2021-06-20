package com.complexity.gaming.help_i.application.domain.model.valueobjects;

public class ApplicationId {

    private String applicationId;

    public ApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationId() {
    }

    @Override
    public String toString(){
        return applicationId;
    }

    @Override
    public int hashCode() {
        return applicationId.hashCode();
    }

    public String getApplicationId() {
        return applicationId;
    }
}
