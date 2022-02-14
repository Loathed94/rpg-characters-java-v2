package com.company.characters;

import com.company.characters.CharacterClass;
import com.company.characters.RogueClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueClassTest {

    @Test
    void GetAttributes_BaseAndTotalAfterIncrementLevel_ExpectedValues3And10And2(){
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

        assertEquals(actualValuesBase, expectedValues);
        assertEquals(actualValuesTotal, expectedValues);
    }

    @Test
    void GetAttributes_BaseAndTotalAfterInstantiation_ExpectValues2And6And1(){
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

        assertEquals(actualValuesBase, expectedValues);
        assertEquals(actualValuesTotal, expectedValues);
    }
}