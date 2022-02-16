package com.company.items;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ItemTest {

    @Test
    void TestItemGetters_GettersAfterInstantiation_ShouldReturnSameValuesAsWasPutInParameter(){
        String expectedName = "Destroyer of Worlds";
        int expectedRequiredLevel = 100;
        EquipmentSlot expectedSlot = EquipmentSlot.WEAPON;
        Item weapon = new Weapon(expectedName, expectedRequiredLevel, WeaponType.HAMMER, 600, 2);

        String actualName = weapon.getName();
        int actualRequiredLevel = weapon.getRequiredLevel();
        EquipmentSlot actualSlot = weapon.getEquipmentSlot();

        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedRequiredLevel, actualRequiredLevel);
        Assertions.assertEquals(expectedSlot, actualSlot);
    }
}