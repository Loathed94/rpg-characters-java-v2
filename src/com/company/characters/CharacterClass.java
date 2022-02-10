package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.items.*;

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

    public CharacterClass(String name, int strength, int dexterity, int intelligence, WeaponType[] weaponTypes, ArmorType[] armorTypes){
        this.name = name;
        this.baseAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
        this.totalAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
        for(int i = 0; i < weaponTypes.length; i++){
            allowedWeaponType.put(weaponTypes[i], true);
        }
        for(int i = 0; i < armorTypes.length; i++){
            allowedArmorType.put(armorTypes[i], true);
        }
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

    private boolean isWeaponAcceptable(Weapon weapon){
        return (allowedWeaponType.get(weapon.getWeaponType()) == true) ? true : false;
    }

    private boolean isArmorAcceptable(Armor armor){
        return (allowedArmorType.get(armor.getArmorType()) == true) ? true : false;
    }

    public void equipItem(Item item){
        if(item instanceof Armor){
            if(isArmorAcceptable((Armor) item)){
                equipment.put(item.getEquipmentSlot(), item);
            }
            else{
                //throw error
            }
        }
        else if(item instanceof Weapon){
            if(isWeaponAcceptable((Weapon) item)){
                equipment.put(item.getEquipmentSlot(), item);
            }
            else{
                //throw error
            }
        }
    }

    private void updateAttributes(){

    }

    protected PrimaryAttribute getBaseAttributes(){
        return this.baseAttributes;
    }

    protected PrimaryAttribute getTotalAttributes(){
        return this.totalAttributes;
    }
}
