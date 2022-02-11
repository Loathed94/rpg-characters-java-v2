package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.exceptions.InvalidArmorException;
import com.company.exceptions.InvalidWeaponException;
import com.company.items.*;

import java.util.HashMap;
import java.util.Map;

public abstract class CharacterClass {
    private final String name;
    private int level = 1;
    private PrimaryAttribute baseAttributes;
    private PrimaryAttribute totalAttributes;
    private final Map<WeaponType, Boolean> allowedWeaponType = new HashMap<>();
    private final Map<ArmorType, Boolean> allowedArmorType = new HashMap<>();
    private Map<EquipmentSlot, Item> equipment = new HashMap<>();

    public CharacterClass(String name, int strength, int dexterity, int intelligence, WeaponType[] weaponTypes, ArmorType[] armorTypes){
        this.name = name;
        this.baseAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
        this.totalAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
        for(WeaponType type : weaponTypes){
            allowedWeaponType.put(type, true);
        }
        for(ArmorType type : armorTypes){
            allowedArmorType.put(type, true);
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
        return allowedWeaponType.get(weapon.getWeaponType());
    }

    private boolean isArmorAcceptable(Armor armor){
        return allowedArmorType.get(armor.getArmorType());
    }

    public void equipItem(Item item){
        try{
            if(item instanceof Armor){
                if(item.getRequiredLevel() > this.level){
                    throw new InvalidArmorException("Your level is too low for that item!");
                }
                if(isArmorAcceptable((Armor) item)){
                    equipment.put(item.getEquipmentSlot(), item);
                    updateAttributes();
                }
                else{
                    throw new InvalidArmorException("Armor type not acceptable for your character class!");
                }
            }
            else if(item instanceof Weapon){
                if(item.getRequiredLevel() > this.level){
                    throw new InvalidWeaponException("Your level is too low for that item!");
                }
                if(isWeaponAcceptable((Weapon) item)){
                    equipment.put(item.getEquipmentSlot(), item);
                    updateAttributes();
                }
                else{
                    throw new InvalidWeaponException("Weapon type not acceptable for your character class!");
                }
            }
        }catch(InvalidArmorException e){
            System.out.println(e);
        }catch (InvalidWeaponException e){
            System.out.println(e);
        }
    }

    public Item getEquipment(EquipmentSlot slot){
        return this.equipment.get(slot);
    }

    private void updateAttributes(){
        int strength = baseAttributes.getStrength();
        int dexterity = baseAttributes.getDexterity();
        int intelligence = baseAttributes.getIntelligence();
        for(Item item : equipment.values()){
            if(item instanceof Armor) {
                strength += ((Armor) item).getAttributes()[0];
                dexterity += ((Armor) item).getAttributes()[1];
                intelligence += ((Armor) item).getAttributes()[2];
            }
        }
        totalAttributes.setStrength(strength);
        totalAttributes.setDexterity(dexterity);
        totalAttributes.setIntelligence(intelligence);
    }

    protected PrimaryAttribute getBaseAttributes(){
        return this.baseAttributes;
    }

    protected PrimaryAttribute getTotalAttributes(){
        return this.totalAttributes;
    }
}
