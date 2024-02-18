package com.ttrpg.quadraticwiz.domain.npc.dtos;

import com.ttrpg.quadraticwiz.domain.npc.enums.Alignments;
import com.ttrpg.quadraticwiz.repositories.entities.NpcAttributeEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class DndNpc extends BaseNpc {
    private String alignment;
    private int armorClass;
    private String hitDie;
    private List<NpcAttributeEntity> savingThrows;
    private int morale;

    public DndNpc() {
        alignment = Alignments.NEUTRAL.name();
        savingThrows = new ArrayList<>();
        morale = 6;

        armorClass = 10;
        hitDie = "2";

    }
}