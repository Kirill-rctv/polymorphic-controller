package com.kochnev.demo.entities;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Hdd extends Product {
    private int value;
}
