package com.complexity.gaming.help_i.domain.model.security;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "experts")
public class Expert extends Person {

    public Expert(@NotNull @Size(max = 100) String name, @NotNull @Size(max = 100) String email, @NotNull Date birthDate) {
        super(name, email, birthDate);
    }

    public Expert() {
    }
}
