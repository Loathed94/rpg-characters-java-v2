package com.company.characters;

import com.company.exceptions.InvalidArmorException;
import com.company.exceptions.InvalidWeaponException;
import com.company.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CharacterClassTest {

    @Test
    void namesShouldBeSetCorrectlyOnInstantiationAndBeGettable(){
        CharacterClass mage = new MageClass("Khadgar");
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        CharacterClass rogue = new RogueClass("Fitting-Rogue-name");
        CharacterClass ranger = new RangerClass("I'm-Actually-A-Hunter");

        String mageName = "Khadgar";
        String warriorName = "Grom Hellscream";
        String rogueName = "Fitting-Rogue-name";
        String rangerName = "I'm-Actually-A-Hunter";

        Assertions.assertEquals(mage.getName(), mageName);
        Assertions.assertEquals(warrior.getName(), warriorName);
        Assertions.assertEquals(rogue.getName(), rogueName);
        Assertions.assertEquals(ranger.getName(), rangerName);
    }

    @Test
    void GetLevel_LevelAfterUsingIncrementLevel_ShouldReturnTheValue2(){
        String characterName = "Grom Hellscream";
        int expectedLevel = 2;
        CharacterClass warrior = new WarriorClass(characterName);

        warrior.incrementLevel();
        int actualLevel = warrior.getLevel();

        Assertions.assertEquals(actualLevel, expectedLevel);
    }

    @Test
    void GetLevel_LevelAtInstantiation_ShouldReturnTheValue1(){
        String characterName = "Grom Hellscream";
        int expectedLevel = 1;
        CharacterClass warrior = new WarriorClass(characterName);

        int actualLevel = warrior.getLevel();

        Assertions.assertEquals(actualLevel, expectedLevel);
    }

    @Test
    void makeSureEquippingItemWorks(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item plate = new Armor("Breastplate of utter Worthlessness", 0, EquipmentSlot.BODY, ArmorType.PLATE, 5, 2, 1);
        Item sword = new Weapon("Blade of something", 0, WeaponType.SWORD, 50, 2);

        Assertions.assertNull(warrior.getEquipment(plate.getEquipmentSlot()));
        Assertions.assertNull(warrior.getEquipment(sword.getEquipmentSlot()));

        try{
            warrior.equipItem(plate);
            warrior.equipItem(sword);
        }catch(InvalidWeaponException e){
            fail();
        }catch(InvalidArmorException e){
            fail();
        }

        Assertions.assertEquals(warrior.getEquipment(plate.getEquipmentSlot()), plate);
        Assertions.assertEquals(warrior.getEquipment(sword.getEquipmentSlot()), sword);
    }

    @Test
    void EquipItem_ItemLevelIsHigherThanCharacter_ShouldThrowInvalidArmorException(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item plate = new Armor("Breastplate of Too High Level For You", 2, EquipmentSlot.BODY, ArmorType.PLATE, 23, 10, 5);

        String expectedExceptionMessage = "InvalidArmorException thrown: Your level is too low for that item!";

        Throwable theExceptionThrown = assertThrows(
                InvalidArmorException.class,
                () -> {
                    warrior.equipItem(plate);
                }
        );
        String actualExceptionMessage = theExceptionThrown.toString();

        Assertions.assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }

    @Test
    void EquipItem_ItemLevelIsHigherThanCharacter_ShouldThrowInvalidWeaponException(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item sword = new Weapon("Blade You Cannot Wield", 2, WeaponType.SWORD, 50, 2);

        String expectedExceptionMessage = "InvalidWeaponException thrown: Your level is too low for that item!";

        Throwable theExceptionThrown = assertThrows(
                InvalidWeaponException.class,
                () -> {
                    warrior.equipItem(sword);
                }
        );
        String actualExceptionMessage = theExceptionThrown.toString();

        Assertions.assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }
}