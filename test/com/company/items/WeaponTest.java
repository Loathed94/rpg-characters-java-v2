package com.company.items;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class WeaponTest {

    @Test
    void TestGetWeaponType_WeaponAtInstantiation_ShouldReturnCorrectType(){
        Weapon hammer = new Weapon("Destroyer of Worlds", 100, WeaponType.HAMMER, 600, 2);

        WeaponType expectedType = WeaponType.HAMMER;
        WeaponType actualType = hammer.getWeaponType();

        Assertions.assertEquals(actualType, expectedType);
    }

    @Test
    void TestGetDPS_WeaponsDPSAfterInstantiation_ShouldReturnValue1200(){
        Weapon hammer = new Weapon("Destroyer of Worlds", 100, WeaponType.HAMMER, 600, 2);

        double expectedDPS = 600*2;
        double actualDPS = hammer.getDPS();

        Assertions.assertEquals(actualDPS, expectedDPS);
    }
}