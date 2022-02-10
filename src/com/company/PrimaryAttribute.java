package com.company;

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

    public int getIntelligence(){
        return this.intelligence;
    }
}
