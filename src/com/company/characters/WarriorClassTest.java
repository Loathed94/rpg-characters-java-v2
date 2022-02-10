package com.company.characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorClassTest {

    @Test
    void makeSureAttributesIncreaseAsTheyShouldForMageClass(){
        CharacterClass warrior = new WarriorClass("Warrior");

        assertEquals(warrior.getBaseAttributes().getStrength(), 5);
        assertEquals(warrior.getBaseAttributes().getDexterity(), 2);
        assertEquals(warrior.getBaseAttributes().getIntelligence(), 1);
        assertEquals(warrior.getTotalAttributes().getStrength(), 5);
        assertEquals(warrior.getTotalAttributes().getDexterity(), 2);
        assertEquals(warrior.getTotalAttributes().getIntelligence(), 1);

        warrior.incrementLevel();

        assertEquals(warrior.getBaseAttributes().getStrength(), 8);
        assertEquals(warrior.getBaseAttributes().getDexterity(), 4);
        assertEquals(warrior.getBaseAttributes().getIntelligence(), 2);
        assertEquals(warrior.getTotalAttributes().getStrength(), 8);
        assertEquals(warrior.getTotalAttributes().getDexterity(), 4);
        assertEquals(warrior.getTotalAttributes().getIntelligence(), 2);

        warrior.incrementLevel();

        assertEquals(warrior.getBaseAttributes().getStrength(), 11);
        assertEquals(warrior.getBaseAttributes().getDexterity(), 6);
        assertEquals(warrior.getBaseAttributes().getIntelligence(), 3);
        assertEquals(warrior.getTotalAttributes().getStrength(), 11);
        assertEquals(warrior.getTotalAttributes().getDexterity(), 6);
        assertEquals(warrior.getTotalAttributes().getIntelligence(), 3);
    }

}