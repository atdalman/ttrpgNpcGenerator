package osr.monsterGenerator.model.npc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import osr.monsterGenerator.model.npc.npcAttributes.*;
import osr.monsterGenerator.service.AttributeService;

import java.time.LocalDateTime;
import java.util.List;

@Data
// A basic monster or NPC
public class BaseNPC {

    @Autowired
    private AttributeService attributeService;

    // Perhaps tied to body shape or distinct features?  For example, a reptilian creature could use a latin name
    // from that part of the animal kingdom
    @Id
    private String id;
    private String name;
    private String properName;
    private LocalDateTime insertDate;
    // Generic flat health points, if desired
    private String healthPoints;
    private Size size;
    private int experienceGiven;
    private BodyShape generalBodyShape;
    private BodySurface bodySurface;
    private Movement movement;
    private DistinctiveFeature distinctiveFeature;
    private PhysicalAttack[] physicalAttacks;
    private String[] specialAbilities;
    private List<CombatStrategy> combatStrategies;
    private List<Motivation> motivations;

    public void setMovement(Movement movement) {
        movement.setNumLimbsFromPossible();
        this.movement = movement;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size: " + size.getName() + "\n" +
                "General Body Shape: " + generalBodyShape.getName() + "\n" +
                "Body Texture: " + bodySurface.getName() + "\n" +
                "Limbs: " + movement.getNumLimbs() + "\n" +
                "Movement Style: " + movement.getMovementStyle() + "\n" +
                "Speed: " + movement.getMovementSpeed() + "\n" +
                "Distinctive Feature: " + distinctiveFeature.getDescription() + "\n");
        sb.append("Motivations: ");
        motivations.forEach(motivation -> sb.append("\t" + motivation.getDescription() + "\n"));
        sb.append("Combat stategies: ");
        combatStrategies.forEach(strategy -> sb.append("\t" + strategy.getDescription() + "\n"));
        return sb.toString();
    }
}
