package com.company.characters;

import com.company.attributes.PrimaryAttribute;

public abstract class CharacterClass {
    private final String NAME;
    private int level = 1;
    private PrimaryAttribute baseAttributes;
    private PrimaryAttribute totalAttributes;

    public CharacterClass(String name, int strength, int dexterity, int intelligence){
        this.NAME = name;
        this.baseAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
        this.totalAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
    }

    public String getName(){
        return this.NAME;
    }

    public void incrementLevel(){
        this.level++;
        increaseAttributesFromLevel();
    }

    public int getLevel(){
        return this.level;
    }

    protected abstract void increaseAttributesFromLevel();
}
