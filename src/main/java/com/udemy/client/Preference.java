package com.udemy.client;

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
public class Preference {

    private int id;
    private int userId;
    private String locale;
    private String diet;
    private boolean notifyOff;
}
