package com.complexity.gaming.help_i.security.application.transform.resource;

import com.complexity.gaming.help_i.shared.model.AuditModel;

import java.util.Date;

public abstract class PersonResource extends AuditModel {

    private Long id;
    private String name;
    private String email;
    private Date birthDate;

    public Long getId() {
        return id;
    }

    public PersonResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public PersonResource setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
