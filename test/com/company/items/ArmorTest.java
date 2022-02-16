package com.company.items;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ArmorTest {

    @Test
    void TestGetAttributes_AttributesOfArmorAtInstantiation_ShouldReturnCorrectValues(){
        Armor armor = new Armor("BlaBla", 4, EquipmentSlot.HEAD, ArmorType.LEATHER, 6, 9, 3);

        int actualStrength = armor.getAttributes()[0];
        int expectedStrength = 6;
        int actualDexterity = armor.getAttributes()[1];
        int expectedDexterity = 9;
        int actualIntelligence = armor.getAttributes()[2];
        int expectedIntelligence = 3;

        Assertions.assertEquals(actualStrength, expectedStrength);
        Assertions.assertEquals(actualDexterity, expectedDexterity);
        Assertions.assertEquals(actualIntelligence, expectedIntelligence);
    }

    @Test
    void TestGetArmorType_InstantiateArmorObjectWithArmorType_ShouldReturnCorrectArmorType(){
        Armor leather = new Armor("BlaBla", 4, EquipmentSlot.HEAD, ArmorType.LEATHER, 6, 9, 3);

        ArmorType actualType = leather.getArmorType();
        ArmorType expectedType = ArmorType.LEATHER;

        Assertions.assertEquals(actualType, expectedType);
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

        Assertions.assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }
}