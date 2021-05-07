package com.complexity.gaming.help_i.resouce;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public abstract class SavePersonResource {

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    private Date birthDate;

    public String getName() {
        return name;
    }

    public SavePersonResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SavePersonResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public SavePersonResource setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
