package com.complexity.gaming.help_i.resource.Training;

import com.complexity.gaming.help_i.resource.Security.ExpertResource;

public class TrainingMaterialResource {

    private Long id;
    private Double price;
    private ExpertResource expert;

    public Long getId() {
        return id;
    }

    public TrainingMaterialResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public TrainingMaterialResource setPrice(Double price) {
        this.price = price;
        return this;
    }

    public ExpertResource getExpert() {
        return expert;
    }

    public TrainingMaterialResource setExpert(ExpertResource expert) {
        this.expert = expert;
        return this;
    }
}
