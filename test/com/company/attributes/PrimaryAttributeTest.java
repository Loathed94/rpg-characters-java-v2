package com.company.attributes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimaryAttributeTest {

    @Test
    void TestGetStrength_ValueRightAfterInstantiation_ShouldReturnSameValueAsWasSetInParameter() {
        int strength1 = 9, dexterity1 = 5, intelligence1 = 7;
        int strength2 = 3, dexterity2 = 6, intelligence2 = 1;
        int strength3 = 100, dexterity3 = 86, intelligence3 = 30;
        PrimaryAttribute strengthIsNine = new PrimaryAttribute(strength1, dexterity1, intelligence1);
        PrimaryAttribute strengthIsThree = new PrimaryAttribute(strength2, dexterity2, intelligence2);
        PrimaryAttribute strengthIsOneHundred = new PrimaryAttribute(strength3, dexterity3, intelligence3);

        int strengthReturned1 = strengthIsNine.getStrength();
        int strengthReturned2 = strengthIsThree.getStrength();
        int strengthReturned3 = strengthIsOneHundred.getStrength();

        Assertions.assertEquals(strengthReturned1, strength1);
        Assertions.assertEquals(strengthReturned2, strength2);
        Assertions.assertEquals(strengthReturned3, strength3);
    }

    @Test
    void TestGetDexterity_ValueRightAfterInstantiation_ShouldReturnSameValueAsWasSetInParameter() {
        int strength1 = 9, dexterity1 = 20, intelligence1 = 7;
        int strength2 = 3, dexterity2 = 6, intelligence2 = 1;
        int strength3 = 100, dexterity3 = 86, intelligence3 = 30;
        PrimaryAttribute dexterityIsTwenty = new PrimaryAttribute(strength1, dexterity1, intelligence1);
        PrimaryAttribute dexterityIsSix = new PrimaryAttribute(strength2, dexterity2, intelligence2);
        PrimaryAttribute dexterityIsEightySix = new PrimaryAttribute(strength3, dexterity3, intelligence3);

        int dexterityReturned1 = dexterityIsTwenty.getDexterity();
        int dexterityReturned2 = dexterityIsSix.getDexterity();
        int dexterityReturned3 = dexterityIsEightySix.getDexterity();


        Assertions.assertEquals(dexterityReturned1, dexterity1);
        Assertions.assertEquals(dexterityReturned2, dexterity2);
        Assertions.assertEquals(dexterityReturned3, dexterity3);
    }

    @Test
    void TestGetIntelligence_ValueRightAfterInstantiation_ShouldReturnSameValueAsWasSetInParameter() {
        int strength1 = 9, dexterity1 = 20, intelligence1 = 2;
        int strength2 = 3, dexterity2 = 6, intelligence2 = 59;
        int strength3 = 100, dexterity3 = 86, intelligence3 = 30;
        PrimaryAttribute intelligenceIsTwo = new PrimaryAttribute(strength1, dexterity1, intelligence1);
        PrimaryAttribute intelligenceIsFiftyNine = new PrimaryAttribute(strength2, dexterity2, intelligence2);
        PrimaryAttribute intelligenceIsThirty = new PrimaryAttribute(strength3, dexterity3, intelligence3);

        int intelligenceReturned1 = intelligenceIsTwo.getIntelligence();
        int intelligenceReturned2 = intelligenceIsFiftyNine.getIntelligence();
        int intelligenceReturned3 = intelligenceIsThirty.getIntelligence();

        Assertions.assertEquals(intelligenceReturned1, intelligence1);
        Assertions.assertEquals(intelligenceReturned2, intelligence2);
        Assertions.assertEquals(intelligenceReturned3, intelligence3);
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