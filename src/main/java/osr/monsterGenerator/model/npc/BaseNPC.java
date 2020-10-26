package osr.monsterGenerator.model.npc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import osr.monsterGenerator.model.npc.npcAttributes.Movement;
import osr.monsterGenerator.model.npc.npcAttributes.NPCAttribute;
import osr.monsterGenerator.model.npc.npcAttributes.Size;
import osr.monsterGenerator.service.AttributeService;

import java.time.LocalDate;
import java.util.List;

//@JsonSerialize(using = BaseNPCSerializer.class)
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
// A basic monster or NPC
public class BaseNPC {

    @Autowired
    private AttributeService attributeService;

    @Id
    private String id;
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
