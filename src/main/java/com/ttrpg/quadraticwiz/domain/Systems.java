package com.ttrpg.quadraticwiz.domain;

public enum Systems {

    ASSH("Astonishing Swordsmen & Sorcerers of Hyperborea"),
    MOTHERSHIP("Mothership"),
    DND5E("Dungeons & Dragons, 5th Edition"),
    DNDBX("Dungeons & Dragons, Basic/Expert"),
    DUNGEON_WORLD("Dungeon World"),
    OSROTHER("Other OSR"), //OSR-compatible stats
    BASE("Base"); //Descriptions and motives only

    public final String fullName;

    Systems(String fullName) {
        this.fullName = fullName;
    }

}