package com.complexity.gaming.help_i.resource.Training;

import javax.validation.constraints.NotNull;

public class SaveTrainingMaterialResource {
    @NotNull
    private Double price;

    public Double getPrice() {
        return price;
    }

    public SaveTrainingMaterialResource setPrice(Double price) {
        this.price = price;
        return this;
    }
}
