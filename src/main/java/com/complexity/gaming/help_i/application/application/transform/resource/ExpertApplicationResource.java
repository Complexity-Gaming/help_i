package com.complexity.gaming.help_i.application.application.transform.resource;

import com.complexity.gaming.help_i.application.domain.model.valueobjects.ApplicationDetail;
import com.complexity.gaming.help_i.application.domain.model.valueobjects.ApplicationId;
import com.complexity.gaming.help_i.application.domain.model.valueobjects.EApplicationStatus;
import com.complexity.gaming.help_i.security.application.transform.resource.PlayerResource;

public class ExpertApplicationResource {

    private Long id;
    private PlayerResource player;
    private ApplicationId tittle;
    private ApplicationDetail applicationDetails;
    private String reviewComment;
    private EApplicationStatus status;

    public Long getId() {
        return id;
    }

    public ExpertApplicationResource setId(Long id) {
        this.id = id;
        return this;
    }

    public ApplicationDetail getApplicationDetails() {
        return applicationDetails;
    }

    public ExpertApplicationResource setApplicationDetails(ApplicationDetail applicationDetails) {
        this.applicationDetails = applicationDetails;
        return this;
    }

    public ApplicationId getTittle() {
        return tittle;
    }

    public ExpertApplicationResource setTittle(ApplicationId tittle) {
        this.tittle = tittle;
        return this;
    }

    public PlayerResource getPlayer() {
        return player;
    }

    public ExpertApplicationResource setPlayer(PlayerResource player) {
        this.player = player;
        return this;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public ExpertApplicationResource setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
        return this;
    }

    public EApplicationStatus getStatus() {
        return status;
    }

    public ExpertApplicationResource setStatus(EApplicationStatus status) {
        this.status = status;
        return this;
    }
}
