package com.company.characters;

import com.company.attributes.PrimaryAttribute;

public class MageClass extends CharacterClass{

    public MageClass(String name){
        super(name, 1, 1, 8);
    }

    @Override
    protected void increaseAttributesFromLevel() {
        PrimaryAttribute base = getBaseAttributes();
        PrimaryAttribute total = getTotalAttributes();
        base.increaseStrength(1);
        base.increaseDexterity(1);
        base.increaseIntelligence(5);
        total.increaseStrength(1);
        total.increaseDexterity(1);
        total.increaseIntelligence(5);
    }
}
