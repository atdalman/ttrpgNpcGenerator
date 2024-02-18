package com.ttrpg.quadraticwiz.mappers;

import com.ttrpg.quadraticwiz.model.npc.dtos.BaseNpc;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {

    BaseNpc toBaseNpc(BaseNpcEntity baseNpc);

}
