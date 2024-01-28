package com.ttrpg.quadraticwiz.model.npc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.ttrpg.quadraticwiz.model.npc.npcAttributes.Movement;
import com.ttrpg.quadraticwiz.model.npc.npcAttributes.NPCAttribute;
import com.ttrpg.quadraticwiz.model.npc.npcAttributes.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

//@JsonSerialize(using = BaseNPCSerializer.class)
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({"_id", "updateDate"})
// A basic monster or NPC
public class BaseNPC {

    @Id
    private String _id;
    private String species;
    private String properName;
    private LocalDate updateDate;
    private Size size;
    private int experienceGiven;
    private NPCAttribute bodyShape;
    private NPCAttribute bodySurface;
    private Movement movement;
    private NPCAttribute peculiarCharacteristic; // Physical or behavioral
    private NPCAttribute[] physicalAttacks;
    private String[] specialAbilities;
    private List<NPCAttribute> combatStrategies;
    private List<NPCAttribute> motivations;

    @JsonSetter("movement")
    public void setMovement(Movement movement) {
        movement.setNumLimbsFromPossible();
        this.movement = movement;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size: " + size.getBriefDescription() + "\n" +
                "General Body Shape: " + bodyShape.getDescription() + "\n" +
                "Body Texture: " + bodySurface.getDescription() + "\n" +
                "Limbs: " + movement.getNumLimbs() + "\n" +
                "Movement Style: " + movement.getDescription() + "\n" +
                "Speed: " + movement.getMovementSpeed() + "\n" +
                "Distinctive Feature: " + peculiarCharacteristic.getDescription() + "\n");
        sb.append("Motivations: ");
        motivations.forEach(motivation -> sb.append("\t" + motivation.getDescription() + "\n"));
        sb.append("Combat stategies: ");
        combatStrategies.forEach(strategy -> sb.append("\t" + strategy.getDescription() + "\n"));
        return sb.toString();
    }
}
