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

    //An abstract class acting as super class for all Hero/Character classes. Used for common attributes and methods for the subclasses.
    public CharacterClass(String name, int strength, int dexterity, int intelligence, WeaponType[] weaponTypes, ArmorType[] armorTypes){
        this.name = name;
        this.baseAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
        this.totalAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
        for(WeaponType type : weaponTypes){ //Allowed WeaponTypes are loaded into a map.
            allowedWeaponType.put(type, true);
        }
        for(ArmorType type : armorTypes){ //Allowed ArmorTypes are loaded into a map.
            allowedArmorType.put(type, true);
        }
    }

    //Simple getter for character's name.
    public String getName(){
        return this.name;
    }

    //Increased level by 1 and makes sure attributes are updated.
    public void incrementLevel(){
        this.level++;
        increaseAttributesFromLevel();
    }

    //Simple getter for level.
    public int getLevel(){
        return this.level;
    }

    //Increase attribute's values for character after it levels up, different for different levels so each class implement the method themselves.
    protected abstract void increaseAttributesFromLevel();

    //Checks if a weapon's type is acceptable for the class in question.
    private boolean isWeaponAcceptable(Weapon weapon){
        if(allowedWeaponType.get(weapon.getWeaponType()) == null){
            return false;
        }
        return true;
    }

    //Checks if an armor's type is acceptable for the class in question.
    private boolean isArmorAcceptable(Armor armor){
        if(allowedArmorType.get(armor.getArmorType()) == null){
            return false;
        }
        return true;
    }

    //Takes in an item, checks first whether it is armor or weapon and then whether character can equip it or not. If not exception is thrown or false returned.
    public boolean equipItem(Item item) throws InvalidArmorException, InvalidWeaponException {
        if(item instanceof Armor){
            if(item.getRequiredLevel() > this.level){ //Character level too low, throw exception.
                throw new InvalidArmorException("Your level is too low for that item!");
            }
            else if(isArmorAcceptable((Armor) item)){ //Item can be equipped, attributes are then updated.
                equipment.put(item.getEquipmentSlot(), item);
                updateAttributes();
                return true;
            }
            else{ //ArmorType is not valid, exception is thrown.
                throw new InvalidArmorException("Armor type not acceptable for your character class!");
            }
        }
        else if(item instanceof Weapon){
            if(item.getRequiredLevel() > this.level){ //Character level too low, throw exception.
                throw new InvalidWeaponException("Your level is too low for that item!");
            }
            else if(isWeaponAcceptable((Weapon) item)){ //Item can be equipped, attributes are then updated.
                equipment.put(item.getEquipmentSlot(), item);
                updateAttributes();
                return true;
            }
            else{ //ArmorType is not valid, exception is thrown.
                throw new InvalidWeaponException("Weapon type not acceptable for your character class!");
            }
        }
        return false; //Should never be reached, unless another class is made to extend Item or null is passed.
    }

    //Simple getter for equipment at a given slot.
    public Item getEquipment(EquipmentSlot slot){
        return this.equipment.get(slot);
    }

    //Attributes are updated after new equipment is equipped.
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

    //Getter for base attributes, however only allowed to be used within package, otherwise would allow outside modification.
    protected PrimaryAttribute getBaseAttributes(){
        return this.baseAttributes;
    }

    //Getter for total attributes, however only allowed to be used within package, otherwise would allow outside modification.
    protected PrimaryAttribute getTotalAttributes(){
        return this.totalAttributes;
    }

    @Override
    public String toString(){
        //Name
        //Level
        //Attributes
        //DPS
        StringBuilder outputString = new StringBuilder();
        outputString.append("Character's name: "+this.name+"\n");
        outputString.append("Character's level: "+this.level+"\n");
        outputString.append("Character's strength: "+this.totalAttributes.getStrength()+"\n");
        outputString.append("Character's dexterity: "+this.totalAttributes.getDexterity()+"\n");
        outputString.append("Character's intelligence: "+this.totalAttributes.getIntelligence()+"\n");
        outputString.append("Character's DPS: "+((DamageDealer) this).getDPS());
        return outputString.toString();
    }
}
