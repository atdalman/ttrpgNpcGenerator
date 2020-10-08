package osr.monsterGenerator.model.npc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import osr.monsterGenerator.model.npc.npcAttributes.Movement;
import osr.monsterGenerator.model.npc.npcAttributes.NPCAttribute;
import osr.monsterGenerator.model.npc.npcAttributes.Size;
import osr.monsterGenerator.service.AttributeService;

import java.time.LocalDateTime;
import java.util.List;

//@JsonSerialize(using = BaseNPCSerializer.class)
@Data
// A basic monster or NPC
public class BaseNPC {

    @Autowired
    private AttributeService attributeService;

    @Id
    private String id;
    private String species;
    private String properName;
    private LocalDateTime insertDate;
    private Size size;
    private int experienceGiven;
    private NPCAttribute bodyShape;
    private NPCAttribute bodySurface;
    private Movement movement;
    private NPCAttribute distinctiveFeature;
    private NPCAttribute[] physicalAttacks;
    private String[] specialAbilities;
    private List<NPCAttribute> combatStrategies;
    private List<NPCAttribute> motivations;

    public void setMovement(Movement movement) {
        movement.setNumLimbsFromPossible();
        this.movement = movement;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size: " + size.getName() + "\n" +
                "General Body Shape: " + bodyShape.getDescription() + "\n" +
                "Body Texture: " + bodySurface.getDescription() + "\n" +
                "Limbs: " + movement.getNumLimbs() + "\n" +
                "Movement Style: " + movement.getDescription() + "\n" +
                "Speed: " + movement.getMovementSpeed() + "\n" +
                "Distinctive Feature: " + distinctiveFeature.getDescription() + "\n");
        sb.append("Motivations: ");
        motivations.forEach(motivation -> sb.append("\t" + motivation.getDescription() + "\n"));
        sb.append("Combat stategies: ");
        combatStrategies.forEach(strategy -> sb.append("\t" + strategy.getDescription() + "\n"));
        return sb.toString();
    }
}
