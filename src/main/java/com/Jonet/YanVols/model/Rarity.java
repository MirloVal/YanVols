package com.Jonet.YanVols.model;

public enum Rarity {

    COMMON("comun"),
    RARE("raro"),
    ULTRA_RARE("ultra raro");
    private String name;

    Rarity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
