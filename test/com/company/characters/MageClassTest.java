package com.company.characters;

import com.company.characters.CharacterClass;
import com.company.characters.MageClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageClassTest {

    @Test
    void GetAttributes_BaseAndTotalAfterIncrementLevel_ExpectedValues2And2And13(){
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

        Assertions.assertEquals(actualValuesBase, expectedValues);
        Assertions.assertEquals(actualValuesTotal, expectedValues);
    }

    @Test
    void GetAttributes_BaseAndTotalAfterInstantiation_ExpectValues1And1And8(){
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

        Assertions.assertEquals(actualValuesBase, expectedValues);
        Assertions.assertEquals(actualValuesTotal, expectedValues);
    }

}