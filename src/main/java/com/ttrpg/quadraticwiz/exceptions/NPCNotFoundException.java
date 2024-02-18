package com.ttrpg.quadraticwiz.exceptions;

public class NpcNotFoundException extends RuntimeException {
    public NpcNotFoundException(String message) {
        super("Npc, referenced by id: " + message + " was not found.");
    }
}
