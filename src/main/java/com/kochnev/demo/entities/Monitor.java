package com.kochnev.demo.entities;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Monitor extends Product {
    private int monitorSize;
}
