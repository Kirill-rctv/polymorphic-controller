package com.kochnev.demo.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kochnev.demo.constatns.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "productType",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Pc.class, name = "PC"),
        @JsonSubTypes.Type(value = Laptop.class, name = "LAPTOP"),
        @JsonSubTypes.Type(value = Monitor.class, name = "MONITOR"),
        @JsonSubTypes.Type(value = Hdd.class, name = "HDD")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int serialNumber;
    private String manufacturer;
    private int price;
    private int quantityOnStock;
    @Enumerated(value = EnumType.STRING)
    private ProductType productType;
}
