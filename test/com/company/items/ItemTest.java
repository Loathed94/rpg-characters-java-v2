package com.company.items;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ItemTest {

    @Test
    void TestItemGetters_GettersAfterInstantiation_ShouldReturnSameValuesAsWasPutInParameter(){
        Item weapon = new Weapon("Destroyer of Worlds", 100, WeaponType.HAMMER, 600, 2);

        String actualName = weapon.getName();
        String expectedName = "Destroyer of Worlds";
        int actualRequiredLevel = weapon.getRequiredLevel();
        int expectedRequiredLevel = 100;
        EquipmentSlot actualSlot = weapon.getEquipmentSlot();
        EquipmentSlot expectedSlot = EquipmentSlot.WEAPON;

        Assertions.assertEquals(actualName, expectedName);
        Assertions.assertEquals(actualRequiredLevel, expectedRequiredLevel);
        Assertions.assertEquals(actualSlot, expectedSlot);
    }
}