package com.company.attributes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimaryAttributeTest {

    @Test
    void TestGetStrength_ValueRightAfterInstantiation_ShouldReturnSameValueAsWasSetInParameter() {
        int expectedStrength1 = 9, dexterity1 = 5, intelligence1 = 7;
        int expectedStrength2 = 3, dexterity2 = 6, intelligence2 = 1;
        int expectedStrength3 = 100, dexterity3 = 86, intelligence3 = 30;
        PrimaryAttribute strengthIsNine = new PrimaryAttribute(expectedStrength1, dexterity1, intelligence1);
        PrimaryAttribute strengthIsThree = new PrimaryAttribute(expectedStrength2, dexterity2, intelligence2);
        PrimaryAttribute strengthIsOneHundred = new PrimaryAttribute(expectedStrength3, dexterity3, intelligence3);

        int actualStrength1 = strengthIsNine.getStrength();
        int actualStrength2 = strengthIsThree.getStrength();
        int actualStrength3 = strengthIsOneHundred.getStrength();

        Assertions.assertEquals(expectedStrength1, actualStrength1);
        Assertions.assertEquals(expectedStrength2, actualStrength2);
        Assertions.assertEquals(expectedStrength3, actualStrength3);
    }

    @Test
    void TestGetDexterity_ValueRightAfterInstantiation_ShouldReturnSameValueAsWasSetInParameter() {
        int strength1 = 9, expectedDexterity1 = 20, intelligence1 = 7;
        int strength2 = 3, expectedDexterity2 = 6, intelligence2 = 1;
        int strength3 = 100, expectedDexterity3 = 86, intelligence3 = 30;
        PrimaryAttribute dexterityIsTwenty = new PrimaryAttribute(strength1, expectedDexterity1, intelligence1);
        PrimaryAttribute dexterityIsSix = new PrimaryAttribute(strength2, expectedDexterity2, intelligence2);
        PrimaryAttribute dexterityIsEightySix = new PrimaryAttribute(strength3, expectedDexterity3, intelligence3);

        int actualDexterity1 = dexterityIsTwenty.getDexterity();
        int actualDexterity2 = dexterityIsSix.getDexterity();
        int actualDexterity3 = dexterityIsEightySix.getDexterity();


        Assertions.assertEquals(expectedDexterity1, actualDexterity1);
        Assertions.assertEquals(expectedDexterity2, actualDexterity2);
        Assertions.assertEquals(expectedDexterity3, actualDexterity3);
    }

    @Test
    void TestGetIntelligence_ValueRightAfterInstantiation_ShouldReturnSameValueAsWasSetInParameter() {
        int strength1 = 9, dexterity1 = 20, expectedIntelligence1 = 2;
        int strength2 = 3, dexterity2 = 6, expectedIntelligence2 = 59;
        int strength3 = 100, dexterity3 = 86, expectedIntelligence3 = 30;
        PrimaryAttribute intelligenceIsTwo = new PrimaryAttribute(strength1, dexterity1, expectedIntelligence1);
        PrimaryAttribute intelligenceIsFiftyNine = new PrimaryAttribute(strength2, dexterity2, expectedIntelligence2);
        PrimaryAttribute intelligenceIsThirty = new PrimaryAttribute(strength3, dexterity3, expectedIntelligence3);

        int actualIntelligence1 = intelligenceIsTwo.getIntelligence();
        int actualIntelligence2 = intelligenceIsFiftyNine.getIntelligence();
        int actualIntelligence3 = intelligenceIsThirty.getIntelligence();

        Assertions.assertEquals(expectedIntelligence1, actualIntelligence1);
        Assertions.assertEquals(expectedIntelligence2, actualIntelligence2);
        Assertions.assertEquals(expectedIntelligence3, actualIntelligence3);
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

    @Test
    void makeSureSettersInPrimaryAttributeWorkAsIntended(){
        PrimaryAttribute attributes = new PrimaryAttribute(9, 7, 2);

        Assertions.assertEquals(attributes.getStrength(), 9);
        Assertions.assertEquals(attributes.getDexterity(), 7);
        Assertions.assertEquals(attributes.getIntelligence(), 2);

        attributes.setStrength(34);
        attributes.setDexterity(87);
        attributes.setIntelligence(16);

        Assertions.assertEquals(attributes.getStrength(), 34);
        Assertions.assertEquals(attributes.getDexterity(), 87);
        Assertions.assertEquals(attributes.getIntelligence(), 16);
    }
}