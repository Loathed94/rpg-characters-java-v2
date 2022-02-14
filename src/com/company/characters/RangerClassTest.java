package com.company.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerClassTest {

    @Test
    void GetAttributes_BaseAndTotalAfterIncrementLevel_ExpectedValues2And12And2(){
        String characterName = "Sylvanas Windrunner";
        CharacterClass ranger = new RangerClass(characterName);
        String expectedValues = "2122";
        String actualValuesBase = "";
        String actualValuesTotal = "";

        ranger.incrementLevel();

        actualValuesBase += ranger.getBaseAttributes().getStrength();
        actualValuesBase += ranger.getBaseAttributes().getDexterity();
        actualValuesBase += ranger.getBaseAttributes().getIntelligence();

        actualValuesTotal += ranger.getTotalAttributes().getStrength();
        actualValuesTotal += ranger.getTotalAttributes().getDexterity();
        actualValuesTotal += ranger.getTotalAttributes().getIntelligence();

        assertEquals(actualValuesBase, expectedValues);
        assertEquals(actualValuesTotal, expectedValues);
    }

    @Test
    void GetAttributes_BaseAndTotalAfterInstantiation_ExpectValues1And7And1(){
        String characterName = "Sylvanas Windrunner";
        CharacterClass ranger = new RangerClass(characterName);
        String expectedValues = "171";
        String actualValuesBase = "";
        String actualValuesTotal = "";

        actualValuesBase += ranger.getBaseAttributes().getStrength();
        actualValuesBase += ranger.getBaseAttributes().getDexterity();
        actualValuesBase += ranger.getBaseAttributes().getIntelligence();

        actualValuesTotal += ranger.getTotalAttributes().getStrength();
        actualValuesTotal += ranger.getTotalAttributes().getDexterity();
        actualValuesTotal += ranger.getTotalAttributes().getIntelligence();

        assertEquals(actualValuesBase, expectedValues);
        assertEquals(actualValuesTotal, expectedValues);
    }
}