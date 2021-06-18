package com.complexity.gaming.help_i.security.domain.model;


import com.complexity.gaming.help_i.domain.model.AuditModel;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
public abstract class Person extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    @NaturalId
    private String email;

    @NotNull
    private Date birthDate;

    public Person(@NotNull @Size(max = 100) String name, @NotNull @Size(max = 100) String email, @NotNull Date birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Person setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
