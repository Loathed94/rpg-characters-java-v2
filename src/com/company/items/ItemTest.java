package com.company.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void makeSureGettersWorkAsExpected(){
        Item weapon1 = new Weapon("Destroyer of Worlds", 100, WeaponType.HAMMER, 600, 2);
        Item weapon2 = new Weapon("Blunt Dagger of Uselessness", 0, WeaponType.DAGGER, 1, 2);
        Item weapon3 = new Weapon("A decent wand", 30, WeaponType.WAND, 60, 3);

        Assertions.assertEquals(weapon1.getName(), "Destroyer of Worlds");
        Assertions.assertEquals(weapon2.getName(), "Blunt Dagger of Uselessness");
        Assertions.assertEquals(weapon3.getName(), "A decent wand");

        Assertions.assertEquals(weapon1.getRequiredLevel(), 100);
        Assertions.assertEquals(weapon2.getRequiredLevel(), 0);
        Assertions.assertEquals(weapon3.getRequiredLevel(), 30);

        Assertions.assertEquals(weapon1.getEquipmentSlot(), EquipmentSlot.WEAPON);
        Assertions.assertEquals(weapon2.getEquipmentSlot(), EquipmentSlot.WEAPON);
        Assertions.assertEquals(weapon3.getEquipmentSlot(), EquipmentSlot.WEAPON);
    }
}