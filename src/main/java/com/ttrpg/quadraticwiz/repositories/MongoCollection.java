package com.ttrpg.quadraticwiz.repositories;

public enum MongoCollection {
    BODY_SHAPE("bodyShape"),
    BODY_SURFACE("bodySurface"),
    COMBAT_STRATEGY("combatStrategy"),
    PECULIAR_CHARACTERISTIC("peculiarCharacteristic"),
    MOTIVATION("motivation"),
    PHYSICAL_ATTACK("physicalAttack"),
    SAVING_THROW("savingThrow"),
    MOVEMENT("movement"),
    SIZE("size"),
    Npc("npc");

    public final String label;

    MongoCollection(String label) {
        this.label = label;
    }
}
