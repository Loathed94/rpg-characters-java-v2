package com.company.characters;

import com.company.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CharacterClassTest {

    @Test
    void shouldThrowErrorBecauseAbstractCannotBeInitialized(){
        //Assertions.assertThrows();
    }

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
    void incrementLevelShouldIncreaseLevelByOneAtATime(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");

        Assertions.assertEquals(warrior.getLevel(), 1);

        warrior.incrementLevel();
        warrior.incrementLevel();

        Assertions.assertEquals(warrior.getLevel(), 3);
    }

    @Test
    void makeSureEquippingItemWorks(){
        CharacterClass warrior = new WarriorClass("Grom Hellscream");
        Item plate = new Armor("Breastplate of utter Worthlessness", 0, EquipmentSlot.BODY, ArmorType.PLATE, 5, 2, 1);
        Item sword = new Weapon("Blade of something", 0, WeaponType.SWORD, 50, 2);

        Assertions.assertEquals(warrior.getEquipment(plate.getEquipmentSlot()), null);
        Assertions.assertEquals(warrior.getEquipment(sword.getEquipmentSlot()), null);

        warrior.equipItem(plate);
        warrior.equipItem(sword);

        Assertions.assertEquals(warrior.getEquipment(plate.getEquipmentSlot()), plate);
        Assertions.assertEquals(warrior.getEquipment(sword.getEquipmentSlot()), sword);
    }
}