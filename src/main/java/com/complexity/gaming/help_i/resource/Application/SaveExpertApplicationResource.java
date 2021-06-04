package com.complexity.gaming.help_i.resource.Application;

import com.complexity.gaming.help_i.domain.model.Application.ApplicationDetail;
import com.complexity.gaming.help_i.domain.model.Application.ApplicationId;
import com.complexity.gaming.help_i.domain.model.Application.EApplicationStatus;

import java.net.URI;

public class SaveExpertApplicationResource {

    private ApplicationId tittle;
    private ApplicationDetail applicationDetails;

    public ApplicationId getTittle() {
        return tittle;
    }

    public SaveExpertApplicationResource setTittle(ApplicationId tittle) {
        this.tittle = tittle;
        return this;
    }

    public ApplicationDetail getApplicationDetails() {
        return applicationDetails;
    }

    public SaveExpertApplicationResource setApplicationDetails(ApplicationDetail applicationDetails) {
        this.applicationDetails = applicationDetails;
        return this;
    }
}
