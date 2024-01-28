package com.ttrpg.quadraticwiz.repository.api;

import com.ttrpg.quadraticwiz.model.npc.npcAttributes.NPCAttribute;

import java.util.List;

public interface AttributeDAO {
    // Equally weighted attributes
    Object getRandomNPCAttribute(String collectionName, List<String> tags,
                                 Class attributeClass);

    // Unequally weighted attributes.
    Object getRandomWeightedNPCAttribute(String collectionName,
                                         List<String> tags, Class attributeClass);

    List<NPCAttribute> getMultipleAttributes(int numResults, String collectionName);

    // Updates chances within each document within a given collection of attributes
    void updateChances(String collectionName);
}
