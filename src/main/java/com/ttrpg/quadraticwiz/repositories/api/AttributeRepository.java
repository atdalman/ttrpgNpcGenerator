package com.ttrpg.quadraticwiz.repositories.api;

import com.ttrpg.quadraticwiz.domain.npc.dtos.NpcAttribute;

import java.util.List;

public interface AttributeRepository {
    // Equally weighted attributes
    Object getRandomNpcAttribute(String collectionName, List<String> tags,
                                 Class attributeClass);

    // Unequally weighted attributes.
    Object getRandomWeightedNpcAttribute(String collectionName,
                                         List<String> tags, Class attributeClass);

    List<NpcAttribute> getMultipleAttributes(int numResults, String collectionName);

    // Updates chances within each document within a given collection of attributes
    void updateChances(String collectionName);
}
