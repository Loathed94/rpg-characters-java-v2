package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.items.ArmorType;
import com.company.items.EquipmentSlot;
import com.company.items.Weapon;
import com.company.items.WeaponType;

public class RogueClass extends CharacterClass{

    //A blade wielding Hero class that extends CharacterClass.
    public RogueClass(String name){
        super(name, 2, 6, 1, new WeaponType[]{WeaponType.DAGGER, WeaponType.SWORD}, new ArmorType[]{ArmorType.LEATHER, ArmorType.MAIL});
    }

    //Overridden method from superclass, increases values of strength, dexterity and intelligence each time rogue levels up.
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

    //Overridden method from superclass, calculates DPS for Rogue using Dexterity and returns the value.
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
