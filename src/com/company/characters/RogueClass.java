package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.items.ArmorType;
import com.company.items.WeaponType;

public class RogueClass extends CharacterClass{

    public RogueClass(String name){
        super(name, 2, 6, 1, new WeaponType[]{WeaponType.DAGGER, WeaponType.SWORD}, new ArmorType[]{ArmorType.LEATHER, ArmorType.MAIL});
    }

    @Override
    protected void increaseAttributesFromLevel() {
        PrimaryAttribute base = getBaseAttributes();
        PrimaryAttribute total = getTotalAttributes();
        base.increaseStrength(1);
        base.increaseDexterity(4);
        base.increaseIntelligence(1);
        total.increaseStrength(1);
        total.increaseDexterity(4);
        total.increaseIntelligence(1);
    }
}
