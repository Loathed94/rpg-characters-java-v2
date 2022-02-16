package com.company.characters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MageClassTest {

    @Test
    void TestGetAttributes_BaseAndTotalAfterIncrementLevel_ExpectedValues2And2And13(){
        String characterName = "Khadgar";
        CharacterClass mage = new MageClass(characterName);
        String expectedValues = "2213";
        String actualValuesBase = "";
        String actualValuesTotal = "";

        mage.incrementLevel();

        actualValuesBase += mage.getBaseAttributes().getStrength();
        actualValuesBase += mage.getBaseAttributes().getDexterity();
        actualValuesBase += mage.getBaseAttributes().getIntelligence();

        actualValuesTotal += mage.getTotalAttributes().getStrength();
        actualValuesTotal += mage.getTotalAttributes().getDexterity();
        actualValuesTotal += mage.getTotalAttributes().getIntelligence();

        Assertions.assertEquals(expectedValues, actualValuesBase);
        Assertions.assertEquals(expectedValues, actualValuesTotal);
    }

    @Test
    void TestGetAttributes_BaseAndTotalAfterInstantiation_ExpectValues1And1And8(){
        String characterName = "Khadgar";
        CharacterClass mage = new MageClass(characterName);
        String expectedValues = "118";
        String actualValuesBase = "";
        String actualValuesTotal = "";

        actualValuesBase += mage.getBaseAttributes().getStrength();
        actualValuesBase += mage.getBaseAttributes().getDexterity();
        actualValuesBase += mage.getBaseAttributes().getIntelligence();

        actualValuesTotal += mage.getTotalAttributes().getStrength();
        actualValuesTotal += mage.getTotalAttributes().getDexterity();
        actualValuesTotal += mage.getTotalAttributes().getIntelligence();

        Assertions.assertEquals(expectedValues, actualValuesBase);
        Assertions.assertEquals(expectedValues, actualValuesTotal);
    }

}