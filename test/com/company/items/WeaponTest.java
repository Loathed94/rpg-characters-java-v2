package com.company.items;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class WeaponTest {

    @Test
    void TestGetWeaponType_WeaponAtInstantiation_ShouldReturnCorrectType(){
        WeaponType expectedType = WeaponType.HAMMER;
        Weapon hammer = new Weapon("Destroyer of Worlds", 100, expectedType, 600, 2);

        WeaponType actualType = hammer.getWeaponType();

        Assertions.assertEquals(expectedType, actualType);
    }

    @Test
    void TestGetDPS_WeaponsDPSAfterInstantiation_ShouldReturnValue1200(){
        Weapon hammer = new Weapon("Destroyer of Worlds", 100, WeaponType.HAMMER, 600, 2);

        double actualDPS = hammer.getDPS();
        double expectedDPS = 600*2;

        Assertions.assertEquals(expectedDPS, actualDPS);
    }
}