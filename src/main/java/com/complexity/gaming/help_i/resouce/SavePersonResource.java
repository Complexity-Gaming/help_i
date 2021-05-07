package com.complexity.gaming.help_i.resouce;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SavePersonResource {

    @NotNull
    @Size(max = 100)
    private String name;


    public String getName() {
        return name;
    }

    public SavePersonResource setName(String name) {
        this.name = name;
        return this;
    }
}
