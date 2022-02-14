package com.company.items;

import com.company.items.Armor;
import com.company.items.ArmorType;
import com.company.items.EquipmentSlot;
import com.company.items.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    @Test
    void makeSureAttributesAreCorrect(){
        Armor armor1 = new Armor("BlaBla", 4, EquipmentSlot.HEAD, ArmorType.LEATHER, 6, 9, 3);
        Armor armor2 = new Armor("Decent item", 50, EquipmentSlot.BODY, ArmorType.MAIL, 30, 50, 18);
        Armor armor3 = new Armor("Bretty good leggins", 70, EquipmentSlot.LEGS, ArmorType.CLOTH, 58, 49, 88);

        Assertions.assertEquals(armor1.getAttributes()[0], 6);
        Assertions.assertEquals(armor1.getAttributes()[1], 9);
        Assertions.assertEquals(armor1.getAttributes()[2], 3);

        Assertions.assertEquals(armor2.getAttributes()[0], 30);
        Assertions.assertEquals(armor2.getAttributes()[1], 50);
        Assertions.assertEquals(armor2.getAttributes()[2], 18);

        Assertions.assertEquals(armor3.getAttributes()[0], 58);
        Assertions.assertEquals(armor3.getAttributes()[1], 49);
        Assertions.assertEquals(armor3.getAttributes()[2], 88);
    }

    @Test
    void makeSureArmorTypesAreCorrect(){
        Armor leather = new Armor("BlaBla", 4, EquipmentSlot.HEAD, ArmorType.LEATHER, 6, 9, 3);
        Armor mail = new Armor("Decent item", 50, EquipmentSlot.BODY, ArmorType.MAIL, 30, 50, 18);
        Armor cloth = new Armor("Bretty good leggins", 70, EquipmentSlot.LEGS, ArmorType.CLOTH, 58, 49, 88);
        Armor plate = new Armor("Breastplate of Awesomeness", 666, EquipmentSlot.BODY, ArmorType.PLATE, 321, 275, 100);

        Assertions.assertEquals(leather.getArmorType(), ArmorType.LEATHER);
        Assertions.assertEquals(mail.getArmorType(), ArmorType.MAIL);
        Assertions.assertEquals(cloth.getArmorType(), ArmorType.CLOTH);
        Assertions.assertEquals(plate.getArmorType(), ArmorType.PLATE);
    }

    @Test
    void makeSureSendingWeaponSlotToArmorClassThrowsIAE(){
        String message = "Armor cannot be assigned to weapon slot!";
        Throwable expectedException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Item armor = new Armor("A fitting name", 8, EquipmentSlot.WEAPON, ArmorType.MAIL, 6, 8, 1);
                }
        );
        assertEquals(expectedException.getMessage(), message);
    }
}