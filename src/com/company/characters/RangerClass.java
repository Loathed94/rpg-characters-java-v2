package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.items.ArmorType;
import com.company.items.WeaponType;

public class RangerClass extends CharacterClass{

    public RangerClass(String name){
        super(name, 1, 7, 1, new WeaponType[]{WeaponType.BOW}, new ArmorType[]{ArmorType.LEATHER, ArmorType.MAIL});
    }

    @Override
    protected void increaseAttributesFromLevel() {
        PrimaryAttribute base = getBaseAttributes();
        PrimaryAttribute total = getTotalAttributes();
        base.increaseStrength(1);
        base.increaseDexterity(5);
        base.increaseIntelligence(1);
        total.increaseStrength(1);
        total.increaseDexterity(5);
        total.increaseIntelligence(1);
    }
}
