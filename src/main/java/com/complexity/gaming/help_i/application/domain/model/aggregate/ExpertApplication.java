package com.complexity.gaming.help_i.application.domain.model.aggregate;

import com.complexity.gaming.help_i.application.domain.model.valueobjects.ApplicationDetail;
import com.complexity.gaming.help_i.application.domain.model.valueobjects.ApplicationId;
import com.complexity.gaming.help_i.application.domain.model.valueobjects.EApplicationStatus;
import com.complexity.gaming.help_i.application.domain.model.converters.ApplicationIdAttributeConverter;
import com.complexity.gaming.help_i.security.domain.model.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ExpertApplications")
public class ExpertApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Convert(converter = ApplicationIdAttributeConverter.class)
    private ApplicationId tittle;

    @Embedded
    private ApplicationDetail applicationDetails;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    @JsonIgnore
    private Player player;

    private String reviewComment;

    private EApplicationStatus status;

    public ExpertApplication() {
    }

    public ExpertApplication(ApplicationId tittle, ApplicationDetail applicationDetails, Player player, String reviewComment, EApplicationStatus status) {
        this.tittle = tittle;
        this.applicationDetails = applicationDetails;
        this.player = player;
        this.reviewComment = reviewComment;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public ExpertApplication setId(Long id) {
        this.id = id;
        return this;
    }

    public ApplicationDetail getApplicationDetails() {
        return applicationDetails;
    }

    public ExpertApplication setApplicationDetails(ApplicationDetail applicationDetails) {
        this.applicationDetails = applicationDetails;
        return this;
    }

    public ApplicationId getTittle() {
        return tittle;
    }

    public ExpertApplication setTittle(ApplicationId tittle) {
        this.tittle = tittle;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public ExpertApplication setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public ExpertApplication setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
        return this;
    }

    public EApplicationStatus getStatus() {
        return status;
    }

    public ExpertApplication setStatus(EApplicationStatus status) {
        this.status = status;
        return this;
    }
}
