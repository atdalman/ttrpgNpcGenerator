package ttrpg.monsterGenerator.exceptions;

public class NPCNotFoundException extends RuntimeException {
    public NPCNotFoundException(String message) {
        super("NPC, referenced by id: " + message + " was not found.");
    }
}
