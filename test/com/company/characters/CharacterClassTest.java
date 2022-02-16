package com.company.characters;

import com.company.exceptions.InvalidArmorException;
import com.company.exceptions.InvalidWeaponException;
import com.company.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CharacterClassTest {

    @Test
    void TestGetName_CharacterIsInstantiatedWithAName_ShouldReturnCorrectName(){
        CharacterClass mage = new MageClass("Khadgar");

        String expectedName = "Khadgar";
        String actualName = mage.getName();

        Assertions.assertEquals(actualName, expectedName);
    }

    @Test
    void TestGetLevel_LevelAfterUsingIncrementLevel_ShouldReturnTheValue2(){
        String characterName = "Grom Hellscream";
        int expectedLevel = 2;
        CharacterClass warrior = new WarriorClass(characterName);

        warrior.incrementLevel();
        int actualLevel = warrior.getLevel();

        Assertions.assertEquals(actualLevel, expectedLevel);
    }

    @Test
    void TestGetLevel_LevelAtInstantiation_ShouldReturnTheValue1(){
        String characterName = "Grom Hellscream";
        int expectedLevel = 1;
        CharacterClass warrior = new WarriorClass(characterName);

        int actualLevel = warrior.getLevel();

        Assertions.assertEquals(actualLevel, expectedLevel);
    }

    @Test
    void TestEquipItem_ValidWeaponForWarrior_ShouldReturnTrue(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item sword = new Weapon("Blade of Being Equipable", 0, WeaponType.SWORD, 50, 2);

        try {
            Assertions.assertTrue(warrior.equipItem(sword));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void TestEquipItem_ValidArmorForWarrior_ShouldReturnTrue(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item plate = new Armor("Breastplate That Absolutely Works For Warriors", 0, EquipmentSlot.BODY, ArmorType.PLATE, 5, 2, 1);

        try{
            Assertions.assertTrue(warrior.equipItem(plate));
        }catch(Exception e){
            fail();
        }
    }

    @Test
    void TestEquipItem_ItemLevelIsHigherThanCharacter_ShouldThrowInvalidArmorException(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item plate = new Armor("Breastplate of Too High Level For You", 2, EquipmentSlot.BODY, ArmorType.PLATE, 23, 10, 5);

        String expectedExceptionMessage = "InvalidArmorException thrown: Your level is too low for that item!";

        Throwable theExceptionThrown = Assertions.assertThrows(
                InvalidArmorException.class,
                () -> {
                    warrior.equipItem(plate);
                }
        );
        String actualExceptionMessage = theExceptionThrown.toString();

        Assertions.assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }

    @Test
    void TestEquipItem_ItemLevelIsHigherThanCharacter_ShouldThrowInvalidWeaponException(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item sword = new Weapon("Blade You Cannot Wield", 2, WeaponType.SWORD, 50, 2);

        String expectedExceptionMessage = "InvalidWeaponException thrown: Your level is too low for that item!";

        Throwable theExceptionThrown = Assertions.assertThrows(
                InvalidWeaponException.class,
                () -> {
                    warrior.equipItem(sword);
                }
        );
        String actualExceptionMessage = theExceptionThrown.toString();

        Assertions.assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }

    @Test
    void TestEquipItem_WeaponTypeNotAllowedForWarriors_ShouldThrowInvalidWeaponException(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item bow = new Weapon("Bow That Only Rangers Can Use", 1, WeaponType.BOW, 50, 3.2);

        String expectedExceptionMessage = "InvalidWeaponException thrown: Weapon type not acceptable for your character class!";

        Throwable theExceptionThrown = Assertions.assertThrows(
                InvalidWeaponException.class,
                () -> {
                    warrior.equipItem(bow);
                }
        );
        String actualExceptionMessage = theExceptionThrown.toString();

        Assertions.assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }

    @Test
    void TestEquipItem_ArmorTypeNotAllowedForWarriors_ShouldThrowInvalidArmorException(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item hood = new Armor("Cloth Hood of Too Soft For A Warrior", 1, EquipmentSlot.HEAD, ArmorType.CLOTH, 2, 1, 23);

        String expectedExceptionMessage = "InvalidArmorException thrown: Armor type not acceptable for your character class!";

        Throwable theExceptionThrown = Assertions.assertThrows(
                InvalidArmorException.class,
                () -> {
                    warrior.equipItem(hood);
                }
        );
        String actualExceptionMessage = theExceptionThrown.toString();

        Assertions.assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }

    @Test
    void TestGetDPS_Level1WarriorWithoutWeapon_ShouldReturnValue1Point05(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        double expectedDPS = 1.0+(5.0/100);

        double actualDPS = ((DamageDealer) warrior).getDPS();

        Assertions.assertEquals(actualDPS, expectedDPS);
    }

    @Test
    void TestGetDPS_Level1WarriorWithWeapon_ShouldReturnValue13Point23() throws InvalidArmorException, InvalidWeaponException {
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item hammer = new Weapon("Hammer of Slight Damageness", 1, WeaponType.HAMMER, 14, 0.9);
        double expectedDPS = (14*0.9)*(1.0+(5.0/100));

        warrior.equipItem(hammer);
        double actualDPS = ((DamageDealer) warrior).getDPS();

        Assertions.assertEquals(actualDPS, expectedDPS);
    }

    @Test
    void TestGetDPS_Level1WarriorWithWeaponAndArmor_ShouldReturnValue13Point608() throws InvalidArmorException, InvalidWeaponException {
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item hammer = new Weapon("Hammer of Slight Damageness", 1, WeaponType.HAMMER, 14, 0.9);
        Item plate = new Armor("Breastplate of Being Slightly Useful", 1, EquipmentSlot.BODY, ArmorType.PLATE, 3, 1, 1);

        double expectedDPS = (14*0.9)*(1.0+(8.0/100));

        warrior.equipItem(hammer);
        warrior.equipItem(plate);
        double actualDPS = ((DamageDealer) warrior).getDPS();

        Assertions.assertEquals(actualDPS, expectedDPS);
    }
}