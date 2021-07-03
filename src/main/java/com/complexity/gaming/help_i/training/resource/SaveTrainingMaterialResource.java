package com.complexity.gaming.help_i.training.resource;

import com.complexity.gaming.help_i.training.domain.model.TrainingDetail;
import com.complexity.gaming.help_i.training.domain.model.TrainingId;

public class SaveTrainingMaterialResource {

    private TrainingId material;

    private TrainingDetail detail;


    public Long getGame() {
        return game;
    }

    public SaveTrainingMaterialResource setGame(Long game) {
        this.game = game;
        return this;
    }

    private Long game;

    public TrainingId getMaterial() {
        return material;
    }

    public SaveTrainingMaterialResource setMaterial(TrainingId material) {
        this.material = material;
        return this;
    }

    public TrainingDetail getDetail() {
        return detail;
    }

    public SaveTrainingMaterialResource setDetail(TrainingDetail detail) {
        this.detail = detail;
        return this;
    }
}
