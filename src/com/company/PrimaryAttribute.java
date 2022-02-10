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

    public void increaseStrength(int increaseBy){
        this.strength += increaseBy;
    }

    public void increaseDexterity(int increaseBy){
        this.dexterity += increaseBy;
    }

    public void increaseIntelligence(int increaseBy){
        this.intelligence += increaseBy;
    }
}
