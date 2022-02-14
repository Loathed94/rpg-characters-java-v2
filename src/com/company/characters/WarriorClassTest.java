package com.company.characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorClassTest {

    @Test
    void GetAttributes_BaseAndTotalAfterIncrementLevel_ExpectedValues8And4And2(){
        String characterName = "Grom Hellscream";
        CharacterClass warrior = new WarriorClass(characterName);
        String expectedValues = "842";
        String actualValuesBase = "";
        String actualValuesTotal = "";

        warrior.incrementLevel();

        actualValuesBase += warrior.getBaseAttributes().getStrength();
        actualValuesBase += warrior.getBaseAttributes().getDexterity();
        actualValuesBase += warrior.getBaseAttributes().getIntelligence();

        actualValuesTotal += warrior.getTotalAttributes().getStrength();
        actualValuesTotal += warrior.getTotalAttributes().getDexterity();
        actualValuesTotal += warrior.getTotalAttributes().getIntelligence();

        assertEquals(actualValuesBase, expectedValues);
        assertEquals(actualValuesTotal, expectedValues);
    }

    @Test
    void GetAttributes_BaseAndTotalAfterInstantiation_ExpectValues5And2And1(){
        String characterName = "Grom Hellscream";
        CharacterClass warrior = new WarriorClass(characterName);
        String expectedValues = "521";
        String actualValuesBase = "";
        String actualValuesTotal = "";

        actualValuesBase += warrior.getBaseAttributes().getStrength();
        actualValuesBase += warrior.getBaseAttributes().getDexterity();
        actualValuesBase += warrior.getBaseAttributes().getIntelligence();

        actualValuesTotal += warrior.getTotalAttributes().getStrength();
        actualValuesTotal += warrior.getTotalAttributes().getDexterity();
        actualValuesTotal += warrior.getTotalAttributes().getIntelligence();

        assertEquals(actualValuesBase, expectedValues);
        assertEquals(actualValuesTotal, expectedValues);
    }

}