package com.complexity.gaming.help_i.resource.training;

import com.complexity.gaming.help_i.domain.model.training.TrainingDetail;
import com.complexity.gaming.help_i.domain.model.training.TrainingId;

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
