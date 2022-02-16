package com.company.items;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ArmorTest {

    @Test
    void TestGetAttributes_AttributesOfArmorAtInstantiation_ShouldReturnCorrectValues(){
        int expectedStrength = 6;
        int expectedDexterity = 9;
        int expectedIntelligence = 3;
        Armor armor = new Armor("BlaBla", 4, EquipmentSlot.HEAD, ArmorType.LEATHER, expectedStrength, expectedDexterity, expectedIntelligence);

        int actualStrength = armor.getAttributes()[0];
        int actualDexterity = armor.getAttributes()[1];
        int actualIntelligence = armor.getAttributes()[2];

        Assertions.assertEquals(expectedStrength, actualStrength);
        Assertions.assertEquals(expectedDexterity, actualDexterity);
        Assertions.assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    void TestGetArmorType_InstantiateArmorObjectWithArmorType_ShouldReturnCorrectArmorType(){
        ArmorType expectedType = ArmorType.LEATHER;
        Armor leather = new Armor("BlaBla", 4, EquipmentSlot.HEAD, expectedType, 6, 9, 3);

        ArmorType actualType = leather.getArmorType();

        Assertions.assertEquals(expectedType, actualType);
    }

    @Test
    void TestIllegalArgumentExceptionAtInstantiation_InstantiateArmorWithWeaponSlot_ShouldThrowIAE(){
        String expectedExceptionMessage = "Armor cannot be assigned to weapon slot!";

        Throwable expectedException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Armor("A fitting name", 8, EquipmentSlot.WEAPON, ArmorType.MAIL, 6, 8, 1);
                }
        );
        String actualExceptionMessage = expectedException.getMessage();

        Assertions.assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }
}