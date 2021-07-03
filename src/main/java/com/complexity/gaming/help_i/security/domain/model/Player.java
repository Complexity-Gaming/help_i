package com.complexity.gaming.help_i.security.domain.model;

import com.complexity.gaming.help_i.training.domain.model.TrainingMaterial;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "players")
public class Player extends Person {


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name ="player_trainings",
            joinColumns =  {@JoinColumn(name = "player_id")},
            inverseJoinColumns = {@JoinColumn(name = "training_id")})
    private List<TrainingMaterial> trainings = new ArrayList<>();

    public Player(@NotNull @Size(max = 100) String name, @NotNull @Size(max = 100) String email, @NotNull Date birthDate,@NotNull String password, List<TrainingMaterial> trainings) {
        super(name, email, birthDate, password);
        this.trainings = trainings;
    }

    public Player() {
    }

    public List<TrainingMaterial> getTrainings() {
        return trainings;
    }

    public Player setTrainings(List<TrainingMaterial> trainings) {
        this.trainings = trainings;
        return this;
    }

    public boolean hasTraining(TrainingMaterial trainingMaterial) {
        return this.getTrainings().contains(trainingMaterial);
    }
    public Player purchaseTrainingMaterial(TrainingMaterial trainingMaterial) {
        if(!hasTraining(trainingMaterial)) {
            this.getTrainings().add(trainingMaterial);
        }
        return this;
    }

}
