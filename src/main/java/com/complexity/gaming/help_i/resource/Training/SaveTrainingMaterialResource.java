package com.complexity.gaming.help_i.resource.Training;

import com.complexity.gaming.help_i.domain.model.Training.TrainingDetail;
import com.complexity.gaming.help_i.domain.model.Training.TrainingId;

import javax.validation.constraints.NotNull;

public class SaveTrainingMaterialResource {

    private TrainingId material;

    private TrainingDetail detail;

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
