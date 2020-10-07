package osr.monsterGenerator.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import osr.monsterGenerator.model.npc.BaseNPC;

import java.io.IOException;

public class BaseNPCSerializer extends JsonSerializer<BaseNPC> {

    public void serialize(BaseNPC npc, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {

        jGen.writeStartObject();
        jGen.writeStringField("Size", npc.getSize().getName());
        jGen.writeStringField("Primary motivation", npc.getMotivations().get(0).getDescription());
        jGen.writeStringField("Secondary motivation", npc.getMotivations().get(1).getDescription());
        jGen.writeEndObject();
    }
}
