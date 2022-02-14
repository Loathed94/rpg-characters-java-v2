package com.company.attributes;

public class PrimaryAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    //A class for storing attribute values for character and Armor objects.
    public PrimaryAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    //Simple getters for the 3 attributes.
    public int getStrength(){
        return this.strength;
    }

    public int getDexterity(){
        return this.dexterity;
    }

    public int getIntelligence(){return this.intelligence; }

    //If we wish to set a specific value these 3 methods can be used.
    public void setStrength(int newStrengthValue){ this.strength = newStrengthValue; }

    public void setDexterity(int newDexterityValue){
        this.dexterity = newDexterityValue;
    }

    public void setIntelligence(int newIntelligenceValue){
        this.intelligence = newIntelligenceValue;
    }

    //If we only wish to increase what is already there these 3 methods can be used.
    public void increaseStrength(int increaseBy){this.strength += increaseBy;}

    public void increaseDexterity(int increaseBy){this.dexterity += increaseBy;}

    public void increaseIntelligence(int increaseBy){this.intelligence += increaseBy;}
}
