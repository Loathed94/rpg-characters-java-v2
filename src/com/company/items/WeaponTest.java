package com.company.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void makeSureWeaponTypeFromGetterIsCorrect(){
        Weapon hammer = new Weapon("Destroyer of Worlds", 100, WeaponType.HAMMER, 600, 2);
        Weapon dagger = new Weapon("Blunt Dagger of Uselessness", 0, WeaponType.DAGGER, 1, 2);
        Weapon wand = new Weapon("A decent wand", 30, WeaponType.WAND, 60, 3);
        Weapon sword = new Weapon("A sharp sword", 46, WeaponType.SWORD, 100, 2);
        Weapon axe = new Weapon("Axe of Hellscream", 70, WeaponType.AXE, 140, 3);
        Weapon bow = new Weapon("A bow!", 5, WeaponType.BOW, 13, 1);
        Weapon staff = new Weapon("A gnarly staff", 29, WeaponType.STAFF, 40, 2);

        Assertions.assertEquals(hammer.getWeaponType(), WeaponType.HAMMER);
        Assertions.assertEquals(dagger.getWeaponType(), WeaponType.DAGGER);
        Assertions.assertEquals(wand.getWeaponType(), WeaponType.WAND);
        Assertions.assertEquals(sword.getWeaponType(), WeaponType.SWORD);
        Assertions.assertEquals(axe.getWeaponType(), WeaponType.AXE);
        Assertions.assertEquals(bow.getWeaponType(), WeaponType.BOW);
        Assertions.assertEquals(staff.getWeaponType(), WeaponType.STAFF);

    }
}