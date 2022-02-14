package com.company.items;

import com.company.attributes.PrimaryAttribute;

public class Armor extends Item{
    private final ArmorType armorType;
    private final PrimaryAttribute attributes;

    //Subclass of Item, armor is an item that has ArmorType and can be worn by a hero class.
    public Armor(String name, int requiredLevel, EquipmentSlot equipmentSlot, ArmorType armorType, int strength, int dexterity, int intelligence){
        super(name, requiredLevel, equipmentSlot);
        checkSlotAcceptability(equipmentSlot);
        this.armorType = armorType;
        this.attributes = new PrimaryAttribute(strength, dexterity, intelligence);
    }

    //Special method that makes sure Armor objects are not instantiated as weapons.
    private void checkSlotAcceptability(EquipmentSlot equipmentSlot){
        if (equipmentSlot == EquipmentSlot.WEAPON){
            throw new IllegalArgumentException("Armor cannot be assigned to weapon slot!");
        }
    }

    //Simple getter for the ArmorType.
    public ArmorType getArmorType() {
        return this.armorType;
    }

    //Returns an array with the values of the 3 attributes.
    public int[] getAttributes(){
        int[] attributesArray = new int[3];
        attributesArray[0] = this.attributes.getStrength();
        attributesArray[1] = this.attributes.getDexterity();
        attributesArray[2] = this.attributes.getIntelligence();
        return attributesArray;
    }
}
