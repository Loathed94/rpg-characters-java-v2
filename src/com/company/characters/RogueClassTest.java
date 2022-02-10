package com.company.characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueClassTest {

    @Test
    void makeSureAttributesIncreaseAsTheyShouldForMageClass(){
        CharacterClass rogue = new RogueClass("Rogue");

        assertEquals(rogue.getBaseAttributes().getStrength(), 2);
        assertEquals(rogue.getBaseAttributes().getDexterity(), 6);
        assertEquals(rogue.getBaseAttributes().getIntelligence(), 1);
        assertEquals(rogue.getTotalAttributes().getStrength(), 2);
        assertEquals(rogue.getTotalAttributes().getDexterity(), 6);
        assertEquals(rogue.getTotalAttributes().getIntelligence(), 1);

        rogue.incrementLevel();

        assertEquals(rogue.getBaseAttributes().getStrength(), 3);
        assertEquals(rogue.getBaseAttributes().getDexterity(), 10);
        assertEquals(rogue.getBaseAttributes().getIntelligence(), 2);
        assertEquals(rogue.getTotalAttributes().getStrength(), 3);
        assertEquals(rogue.getTotalAttributes().getDexterity(), 10);
        assertEquals(rogue.getTotalAttributes().getIntelligence(), 2);

        rogue.incrementLevel();

        assertEquals(rogue.getBaseAttributes().getStrength(), 4);
        assertEquals(rogue.getBaseAttributes().getDexterity(), 14);
        assertEquals(rogue.getBaseAttributes().getIntelligence(), 3);
        assertEquals(rogue.getTotalAttributes().getStrength(), 4);
        assertEquals(rogue.getTotalAttributes().getDexterity(), 14);
        assertEquals(rogue.getTotalAttributes().getIntelligence(), 3);
    }
}