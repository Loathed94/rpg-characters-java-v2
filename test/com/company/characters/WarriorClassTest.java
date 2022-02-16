package com.company.characters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class WarriorClassTest {

    @Test
    void TestGetAttributes_BaseAndTotalAfterIncrementLevel_ExpectedValues8And4And2(){
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

        Assertions.assertEquals(expectedValues, actualValuesBase);
        Assertions.assertEquals(expectedValues, actualValuesTotal);
    }

    @Test
    void TestGetAttributes_BaseAndTotalAfterInstantiation_ExpectValues5And2And1(){
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

        Assertions.assertEquals(expectedValues, actualValuesBase);
        Assertions.assertEquals(expectedValues, actualValuesTotal);
    }

}