package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.items.ArmorType;
import com.company.items.EquipmentSlot;
import com.company.items.Weapon;
import com.company.items.WeaponType;

public class RangerClass extends CharacterClass{

    //A bow wielding Hero class that extends CharacterClass.
    public RangerClass(String name){
        super(name, 1, 7, 1, new WeaponType[]{WeaponType.BOW}, new ArmorType[]{ArmorType.LEATHER, ArmorType.MAIL});
    }

    //Overridden method from superclass, increases values of strength, dexterity and intelligence each time ranger levels up.
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

    //Overridden method from superclass, calculates DPS for Ranger using Dexterity and returns the value.
    @Override
    public double getDPS() {
        double weaponDPS;
        if(getEquipment(EquipmentSlot.WEAPON) != null) {
            weaponDPS = ((Weapon) getEquipment(EquipmentSlot.WEAPON)).getDPS();
        }else{
            weaponDPS = 1;
        }
        double dpsFromAttribute = 1.0 + ((double) getTotalAttributes().getDexterity())/100.0;

        return weaponDPS*dpsFromAttribute;
    }
}
