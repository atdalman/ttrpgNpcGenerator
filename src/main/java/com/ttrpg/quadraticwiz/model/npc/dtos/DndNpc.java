package com.ttrpg.quadraticwiz.model.npc.dtos;

import com.ttrpg.quadraticwiz.model.npc.npcAttributes.Alignments;
import com.ttrpg.quadraticwiz.model.npc.npcAttributes.NpcAttribute;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class DndNpc extends BaseNpc {
    private final String alignment;
    private final int armorClass;
    private final String hitDie;
    private final List<NpcAttribute> savingThrows;
    private final String morale;

    public DndNpc() {
        super();
        alignment = Alignments.NEUTRAL.name();
        armorClass = 10;
        hitDie = "2";

    }
}