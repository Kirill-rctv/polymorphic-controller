package com.kochnev.demo.entities;

import com.kochnev.demo.constatns.FormFactor;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Pc extends Product {
    @Enumerated(value = EnumType.STRING)
    private FormFactor formFactor;
}
