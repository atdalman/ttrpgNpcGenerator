package com.ttrpg.quadraticwiz.mappers;

import com.ttrpg.quadraticwiz.domain.npc.dtos.*;
import com.ttrpg.quadraticwiz.repositories.entities.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    BaseNpc toBaseNpc(BaseNpcEntity baseNpc);

    BaseNpcEntity toBaseNpcEntity(BaseNpc baseNpc);

    DndNpc toDndNpc(DndNpcEntity dndNpcEntity);

    DndNpcEntity toDndNpcEntity(DndNpc dndNpc);

    PhysicalAttack toPhysicalAttack(PhysicalAttackEntity physicalAttackEntity);

    Size toSize(SizeEntity sizeEntity);

    NpcAttribute toNpcAttribute(NpcAttributeEntity npcAttribute);

}
