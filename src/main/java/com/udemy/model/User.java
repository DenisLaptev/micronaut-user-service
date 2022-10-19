package com.udemy.model;

import io.micronaut.core.annotation.Introspected;
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
    private int id;

    @NotBlank
    @Column(name="name")
    private String name;

    @NotBlank
    @Column(name="mobileNumber")
    private String mobileNumber;

    @NotBlank
    @Column(name="email")
    private String email;
}
