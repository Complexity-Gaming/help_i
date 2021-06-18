package com.complexity.gaming.help_i.training.resource;

import com.complexity.gaming.help_i.training.domain.model.TrainingDetail;
import com.complexity.gaming.help_i.training.domain.model.TrainingId;
import com.complexity.gaming.help_i.security.resource.ExpertResource;

public class TrainingMaterialResource {

    private Long id;
    private ExpertResource expert;
    private TrainingId material;
    private TrainingDetail detail;

    public Long getId() {
        return id;
    }

    public TrainingMaterialResource setId(Long id) {
        this.id = id;
        return this;
    }

    public ExpertResource getExpert() {
        return expert;
    }

    public TrainingMaterialResource setExpert(ExpertResource expert) {
        this.expert = expert;
        return this;
    }

    public TrainingId getMaterial() {
        return material;
    }

    public TrainingMaterialResource setMaterial(TrainingId material) {
        this.material = material;
        return this;
    }

    public TrainingDetail getDetail() {
        return detail;
    }

    public TrainingMaterialResource setDetail(TrainingDetail detail) {
        this.detail = detail;
        return this;
    }
}
