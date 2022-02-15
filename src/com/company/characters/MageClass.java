package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.items.ArmorType;
import com.company.items.EquipmentSlot;
import com.company.items.Weapon;
import com.company.items.WeaponType;

public class MageClass extends CharacterClass implements DamageDealer{

    //A magic wielding Hero class that extends CharacterClass.
    public MageClass(String name){
        super(name, 1, 1, 8, new WeaponType[]{WeaponType.STAFF, WeaponType.WAND}, new ArmorType[]{ArmorType.CLOTH});
    }

    //Overridden method from superclass, increases values of strength, dexterity and intelligence each time mage levels up.
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

    //Overridden method from superclass, calculates DPS for Mage using Intelligence and returns the value.
    public double getDPS() {
        double weaponDPS;
        if(getEquipment(EquipmentSlot.WEAPON) != null) {
            weaponDPS = ((Weapon) getEquipment(EquipmentSlot.WEAPON)).getDPS();
        }else{
            weaponDPS = 1;
        }
        double dpsFromAttribute = 1.0 + ((double) getTotalAttributes().getIntelligence())/100.0;

        return weaponDPS*dpsFromAttribute;
    }
}
