package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimaryAttributeTest {

    @Test
    void makeSureValueOfStrengthReturnedByGetterIsCorrect() {
        PrimaryAttribute strengthIsNine = new PrimaryAttribute(9, 5, 7);
        PrimaryAttribute strengthIsThree = new PrimaryAttribute(3, 6, 1);
        PrimaryAttribute strengthIsOneHundred = new PrimaryAttribute(100, 86, 30);

        Assertions.assertEquals(strengthIsNine.getStrength(), 9);
        Assertions.assertEquals(strengthIsThree.getStrength(), 3);
        Assertions.assertEquals(strengthIsOneHundred.getStrength(), 100);
    }

    @Test
    void makeSureValueOfDexterityReturnedByGetterIsCorrect() {
        PrimaryAttribute dexterityIsTwenty = new PrimaryAttribute(9, 20, 7);
        PrimaryAttribute dexterityIsSix = new PrimaryAttribute(3, 6, 1);
        PrimaryAttribute dexterityIsEightySix = new PrimaryAttribute(100, 86, 30);

        Assertions.assertEquals(dexterityIsTwenty.getDexterity(), 20);
        Assertions.assertEquals(dexterityIsSix.getDexterity(), 6);
        Assertions.assertEquals(dexterityIsEightySix.getDexterity(), 86);
    }

    @Test
    void makeSureValueOfIntelligenceReturnedByGetterIsCorrect() {
        PrimaryAttribute intelligenceIsTwo = new PrimaryAttribute(9, 20, 2);
        PrimaryAttribute intelligenceIsFiftyNine = new PrimaryAttribute(3, 6, 59);
        PrimaryAttribute intelligenceIsThirty = new PrimaryAttribute(100, 86, 30);

        Assertions.assertEquals(intelligenceIsTwo.getIntelligence(), 2);
        Assertions.assertEquals(intelligenceIsFiftyNine.getIntelligence(), 59);
        Assertions.assertEquals(intelligenceIsThirty.getIntelligence(), 30);
    }

    @Test
    void makeSureIncreasingAttributesHasTheDesiredEffect(){
        PrimaryAttribute lowAttributeValues = new PrimaryAttribute(9, 7, 2);

        lowAttributeValues.increaseStrength(4);
        lowAttributeValues.increaseDexterity(5);
        lowAttributeValues.increaseIntelligence(8);

        Assertions.assertEquals(lowAttributeValues.getStrength(), 9+4);
        Assertions.assertEquals(lowAttributeValues.getDexterity(), 7+5);
        Assertions.assertEquals(lowAttributeValues.getIntelligence(), 2+8);

        lowAttributeValues.increaseStrength(1);
        lowAttributeValues.increaseDexterity(2);
        lowAttributeValues.increaseIntelligence(3);

        Assertions.assertEquals(lowAttributeValues.getStrength(), 9+4+1);
        Assertions.assertEquals(lowAttributeValues.getDexterity(), 7+5+2);
        Assertions.assertEquals(lowAttributeValues.getIntelligence(), 2+8+3);
    }
}