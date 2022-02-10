package com.company.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageClassTest {

    @Test
    void makeSureAttributesIncreaseAsTheyShouldForMageClass(){
        CharacterClass mage = new MageClass("Khadgar");

        Assertions.assertEquals(mage.getBaseAttributes().getStrength(), 1);
        Assertions.assertEquals(mage.getBaseAttributes().getDexterity(), 1);
        Assertions.assertEquals(mage.getBaseAttributes().getIntelligence(), 8);
        Assertions.assertEquals(mage.getTotalAttributes().getStrength(), 1);
        Assertions.assertEquals(mage.getTotalAttributes().getDexterity(), 1);
        Assertions.assertEquals(mage.getTotalAttributes().getIntelligence(), 8);

        mage.incrementLevel();

        Assertions.assertEquals(mage.getBaseAttributes().getStrength(), 2);
        Assertions.assertEquals(mage.getBaseAttributes().getDexterity(), 2);
        Assertions.assertEquals(mage.getBaseAttributes().getIntelligence(), 13);
        Assertions.assertEquals(mage.getTotalAttributes().getStrength(), 2);
        Assertions.assertEquals(mage.getTotalAttributes().getDexterity(), 2);
        Assertions.assertEquals(mage.getTotalAttributes().getIntelligence(), 13);

        mage.incrementLevel();

        Assertions.assertEquals(mage.getBaseAttributes().getStrength(), 3);
        Assertions.assertEquals(mage.getBaseAttributes().getDexterity(), 3);
        Assertions.assertEquals(mage.getBaseAttributes().getIntelligence(), 18);
        Assertions.assertEquals(mage.getTotalAttributes().getStrength(), 3);
        Assertions.assertEquals(mage.getTotalAttributes().getDexterity(), 3);
        Assertions.assertEquals(mage.getTotalAttributes().getIntelligence(), 18);
    }

}