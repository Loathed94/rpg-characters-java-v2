package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.items.ArmorType;
import com.company.items.EquipmentSlot;
import com.company.items.Item;
import com.company.items.WeaponType;

import java.util.HashMap;
import java.util.Map;

public abstract class CharacterClass {
    private final String name;
    private int level = 1;
    private PrimaryAttribute baseAttributes;
    private PrimaryAttribute totalAttributes;
    private Map<WeaponType, Boolean> allowedWeaponType = new HashMap<>();
    private Map<ArmorType, Boolean> allowedArmorType = new HashMap<>();
    private Map<EquipmentSlot, Item> equipment = new HashMap<>();

    public CharacterClass(String name, int strength, int dexterity, int intelligence){
        this.name = name;
        this.baseAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
        this.totalAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
    }

    public String getName(){
        return this.name;
    }

    public void incrementLevel(){
        this.level++;
        increaseAttributesFromLevel();
    }

    public int getLevel(){
        return this.level;
    }

    protected abstract void increaseAttributesFromLevel();

    protected PrimaryAttribute getBaseAttributes(){
        return this.baseAttributes;
    }

    protected PrimaryAttribute getTotalAttributes(){
        return this.totalAttributes;
    }
}
