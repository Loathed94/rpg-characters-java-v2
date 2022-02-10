package com.company.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerClassTest {

    @Test
    void makeSureAttributesIncreaseAsTheyShouldForMageClass(){
        CharacterClass ranger = new RangerClass("Ranger");

        assertEquals(ranger.getBaseAttributes().getStrength(), 1);
        assertEquals(ranger.getBaseAttributes().getDexterity(), 7);
        assertEquals(ranger.getBaseAttributes().getIntelligence(), 1);
        assertEquals(ranger.getTotalAttributes().getStrength(), 1);
        assertEquals(ranger.getTotalAttributes().getDexterity(), 7);
        assertEquals(ranger.getTotalAttributes().getIntelligence(), 1);

        ranger.incrementLevel();

        assertEquals(ranger.getBaseAttributes().getStrength(), 2);
        assertEquals(ranger.getBaseAttributes().getDexterity(), 12);
        assertEquals(ranger.getBaseAttributes().getIntelligence(), 2);
        assertEquals(ranger.getTotalAttributes().getStrength(), 2);
        assertEquals(ranger.getTotalAttributes().getDexterity(), 12);
        assertEquals(ranger.getTotalAttributes().getIntelligence(), 2);

        ranger.incrementLevel();

        assertEquals(ranger.getBaseAttributes().getStrength(), 3);
        assertEquals(ranger.getBaseAttributes().getDexterity(), 17);
        assertEquals(ranger.getBaseAttributes().getIntelligence(), 3);
        assertEquals(ranger.getTotalAttributes().getStrength(), 3);
        assertEquals(ranger.getTotalAttributes().getDexterity(), 17);
        assertEquals(ranger.getTotalAttributes().getIntelligence(), 3);
    }
}