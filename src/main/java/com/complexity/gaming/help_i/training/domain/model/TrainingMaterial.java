package com.complexity.gaming.help_i.training.domain.model;

import com.complexity.gaming.help_i.security.domain.model.Expert;
import com.complexity.gaming.help_i.security.domain.model.Player;
import com.complexity.gaming.help_i.training.domain.model.converters.TrainingIdAttributeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "trainings")
public class TrainingMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @Embedded
    private TrainingDetail detail;

    public Long getGame() {
        return game;
    }

    public TrainingMaterial setGame(Long game) {
        this.game = game;
        return this;
    }

    @NotNull
    private Long game;

    @Convert(converter = TrainingIdAttributeConverter.class)
    private TrainingId material;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "expert_id", nullable = false)
    @JsonIgnore
    private Expert expert;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "trainings")
    private List<Player> players;

    public TrainingMaterial() {
    }

    public TrainingMaterial(TrainingDetail detail, TrainingId material, Expert expert, List<Player> players, Long game, String description) {
        this.detail = detail;
        this.game = game;
        this.material = material;
        this.expert = expert;
        this.players = players;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public TrainingMaterial setId(Long id) {
        this.id = id;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public TrainingMaterial setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public TrainingMaterial setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }


    public TrainingId getMaterial() {
        return material;
    }

    public TrainingMaterial setMaterial(TrainingId material) {
        this.material = material;
        return this;
    }

    public TrainingDetail getDetail() {
        return detail;
    }

    public TrainingMaterial setDetail(TrainingDetail detail) {
        this.detail = detail;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TrainingMaterial setDescription(String description) {
        this.description = description;
        return this;
    }
}
