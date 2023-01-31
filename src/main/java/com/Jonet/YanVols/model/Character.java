package com.Jonet.YanVols.model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Column;

public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column("name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column("rarity")
    private Rarity rarity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
}
