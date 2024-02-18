package com.ttrpg.quadraticwiz.repositories.entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

//@JsonSerialize(using = BaseNpcSerializer.class)
@Data
@SuperBuilder
@NoArgsConstructor
// A basic monster or Npc
public class BaseNpcEntity implements Serializable {

    @Id
    private long _id;
    private UUID npcId;
    private String species;
    private String properName;
    private LocalDate updateDate;
    private SizeEntity size;
    private int experienceGiven;
    private NpcAttributeEntity bodyShape;
    private NpcAttributeEntity bodySurface;
    private MovementEntity movement;
    private NpcAttributeEntity peculiarCharacteristic; // Physical or behavioral
    private List<NpcAttributeEntity> physicalAttacks;
    private List<String> specialAbilities;
    private List<NpcAttributeEntity> combatStrategies;
    private List<NpcAttributeEntity> motivations;

    @JsonSetter("movement")
    public void setMovement(MovementEntity movement) {
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
