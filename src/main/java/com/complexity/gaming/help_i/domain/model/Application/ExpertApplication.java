package com.complexity.gaming.help_i.domain.model.Application;

import com.complexity.gaming.help_i.domain.model.Application.converters.ApplicationIdAttributeConverter;
import com.complexity.gaming.help_i.domain.model.Security.Player;
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


    public ExpertApplication() {
    }

    public ExpertApplication(ApplicationId tittle, ApplicationDetail applicationDetails, Player player) {
        this.tittle = tittle;
        this.applicationDetails = applicationDetails;
        this.player = player;
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
}
