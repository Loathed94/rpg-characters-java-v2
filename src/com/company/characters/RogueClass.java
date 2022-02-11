package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.items.ArmorType;
import com.company.items.EquipmentSlot;
import com.company.items.Weapon;
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
