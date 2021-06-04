package com.complexity.gaming.help_i.domain.model.Training;

import com.complexity.gaming.help_i.domain.model.Security.Expert;
import com.complexity.gaming.help_i.domain.model.Security.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "trainins")
public class TrainingMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Double Price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "expert_id", nullable = false)
    @JsonIgnore
    private Expert expert;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "trainings")
    private List<Player> players;

    public TrainingMaterial(@NotNull Double price, Expert expert, List<Player> players) {
        Price = price;
        this.expert = expert;
        this.players = players;
    }

    public TrainingMaterial() {
    }

    public Long getId() {
        return id;
    }

    public TrainingMaterial setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getPrice() {
        return Price;
    }

    public TrainingMaterial setPrice(Double price) {
        Price = price;
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
}
