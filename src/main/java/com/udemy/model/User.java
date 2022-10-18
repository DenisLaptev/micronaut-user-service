package com.udemy.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.MappedEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @NotBlank
    @Column
    private String name;
    @NotBlank
    @Column
    private String mobileNumber;
    @NotBlank
    @Column
    private String email;

}
