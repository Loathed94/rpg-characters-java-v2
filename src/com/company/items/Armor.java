package com.company.items;

import com.company.attributes.PrimaryAttribute;

public class Armor extends Item{
    private final ArmorType armorType;
    private final PrimaryAttribute attributes;

    public Armor(String name, int requiredLevel, EquipmentSlot equipmentSlot, ArmorType armorType, int strength, int dexterity, int intelligence){
        super(name, requiredLevel, equipmentSlot);
        checkSlotAcceptability(equipmentSlot);
        this.armorType = armorType;
        this.attributes = new PrimaryAttribute(strength, dexterity, intelligence);
    }

    private void checkSlotAcceptability(EquipmentSlot equipmentSlot){
        if (equipmentSlot == EquipmentSlot.WEAPON){
            throw new IllegalArgumentException("Armor cannot be assigned to weapon slot!");
        }
    }

    public ArmorType getArmorType() {
        return this.armorType;
    }

    public int[] getAttributes(){
        int[] attributesArray = new int[3];
        attributesArray[0] = this.attributes.getStrength();
        attributesArray[1] = this.attributes.getDexterity();
        attributesArray[2] = this.attributes.getIntelligence();
        return attributesArray;
    }
}
