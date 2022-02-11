package com.company.attributes;

public class PrimaryAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public PrimaryAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public int getStrength(){
        return this.strength;
    }

    public int getDexterity(){
        return this.dexterity;
    }

    public int getIntelligence(){return this.intelligence; }

    public void setStrength(int newStrengthValue){
        this.strength = newStrengthValue;
    }

    public void setDexterity(int newDexterityValue){
        this.dexterity = newDexterityValue;
    }

    public void setIntelligence(int newIntelligenceValue){
        this.intelligence = newIntelligenceValue;
    }
}
