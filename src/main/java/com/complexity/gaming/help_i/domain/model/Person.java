package com.complexity.gaming.help_i.domain.model;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    @NaturalId
    private String name;

    @NotNull
    @Size(max = 100)
    @NaturalId
    private String email;

    @NotNull
    private Date birthDate;

}
