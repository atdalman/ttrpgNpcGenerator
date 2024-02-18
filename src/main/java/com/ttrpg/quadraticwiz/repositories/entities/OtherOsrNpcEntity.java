package com.ttrpg.quadraticwiz.repositories.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class OtherOsrNpcEntity extends BaseNpcEntity {
    public OtherOsrNpcEntity() {
    }
}
