package com.company.characters;

import com.company.attributes.PrimaryAttribute;
import com.company.items.ArmorType;
import com.company.items.EquipmentSlot;
import com.company.items.Weapon;
import com.company.items.WeaponType;

public class WarriorClass extends CharacterClass{

    public WarriorClass(String name){
        super(name, 5, 2, 1, new WeaponType[]{WeaponType.AXE, WeaponType.HAMMER, WeaponType.SWORD}, new ArmorType[]{ArmorType.MAIL, ArmorType.PLATE});
    }

    @Override
    protected void increaseAttributesFromLevel() {
        PrimaryAttribute base = getBaseAttributes();
        PrimaryAttribute total = getTotalAttributes();
        base.increaseStrength(3);
        base.increaseDexterity(2);
        base.increaseIntelligence(1);
        total.increaseStrength(3);
        total.increaseDexterity(2);
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
        double dpsFromAttribute = 1.0 + ((double) getTotalAttributes().getStrength())/100.0;

        return weaponDPS*dpsFromAttribute;
    }
}
