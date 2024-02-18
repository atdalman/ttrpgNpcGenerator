package com.ttrpg.quadraticwiz.domain.npc.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class OtherOsrNpc extends BaseNpc {
    public OtherOsrNpc() {
        super();
    }
}
