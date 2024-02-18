package com.ttrpg.quadraticwiz.exceptions;

import java.util.UUID;

public class NpcNotFoundException extends RuntimeException {
    public NpcNotFoundException(UUID npcId) {
        super("Npc, referenced by id: " + npcId + " was not found.");
    }
}
