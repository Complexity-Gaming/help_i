package com.complexity.gaming.help_i.domain.model.training;


import javax.validation.constraints.NotNull;

public class TrainingId {

    private String trainingId;

    public TrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public TrainingId() {
    }

    public String getTrainingId() {
        return trainingId;
    }

    @Override
    public @NotNull String toString(){
        return trainingId;
    }

    @Override
    public int hashCode(){
        return trainingId.hashCode();
    }
}
