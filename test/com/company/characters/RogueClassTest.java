package com.company.characters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class RogueClassTest {

    @Test
    void TestGetAttributes_BaseAndTotalAfterIncrementLevel_ExpectedValues3And10And2(){
        String characterName = "Akama";
        CharacterClass rogue = new RogueClass(characterName);
        String expectedValues = "3102";
        String actualValuesBase = "";
        String actualValuesTotal = "";

        rogue.incrementLevel();

        actualValuesBase += rogue.getBaseAttributes().getStrength();
        actualValuesBase += rogue.getBaseAttributes().getDexterity();
        actualValuesBase += rogue.getBaseAttributes().getIntelligence();

        actualValuesTotal += rogue.getTotalAttributes().getStrength();
        actualValuesTotal += rogue.getTotalAttributes().getDexterity();
        actualValuesTotal += rogue.getTotalAttributes().getIntelligence();

        Assertions.assertEquals(actualValuesBase, expectedValues);
        Assertions.assertEquals(actualValuesTotal, expectedValues);
    }

    @Test
    void TestGetAttributes_BaseAndTotalAfterInstantiation_ExpectValues2And6And1(){
        String characterName = "Akama";
        CharacterClass rogue = new RogueClass(characterName);
        String expectedValues = "261";
        String actualValuesBase = "";
        String actualValuesTotal = "";

        actualValuesBase += rogue.getBaseAttributes().getStrength();
        actualValuesBase += rogue.getBaseAttributes().getDexterity();
        actualValuesBase += rogue.getBaseAttributes().getIntelligence();

        actualValuesTotal += rogue.getTotalAttributes().getStrength();
        actualValuesTotal += rogue.getTotalAttributes().getDexterity();
        actualValuesTotal += rogue.getTotalAttributes().getIntelligence();

        Assertions.assertEquals(actualValuesBase, expectedValues);
        Assertions.assertEquals(actualValuesTotal, expectedValues);
    }
}