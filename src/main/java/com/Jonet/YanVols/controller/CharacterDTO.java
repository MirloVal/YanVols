package com.Jonet.YanVols.controller;

import com.Jonet.YanVols.model.Rarity;

public class CharacterDTO {

    private String name;

    private Rarity rarity;

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
