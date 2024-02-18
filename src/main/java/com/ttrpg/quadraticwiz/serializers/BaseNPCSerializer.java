package com.ttrpg.quadraticwiz.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;

import java.io.IOException;

// TODO Confirm still useful
public class BaseNpcSerializer extends JsonSerializer<BaseNpcEntity> {

    public void serialize(BaseNpcEntity npc, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {

        jGen.writeStartObject();
        jGen.writeStringField("size", npc.getSize().getBriefDescription());
        jGen.writeStringField("species", npc.getSpecies());
        jGen.writeStringField("properName", npc.getProperName());
        jGen.writeStringField("bodyShape", npc.getBodyShape().getDescription());
        jGen.writeStringField("primaryMotivation", npc.getMotivations().get(0).getDescription());
        jGen.writeStringField("secondaryMotivation", npc.getMotivations().get(1).getDescription());

        jGen.writeEndObject();
    }
}