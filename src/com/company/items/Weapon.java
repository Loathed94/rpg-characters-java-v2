package com.company.items;

public class Weapon extends Item{
    private final WeaponType weaponType;

    public Weapon(String name, int requiredLevel, WeaponType weaponType){
        super(name, requiredLevel, EquipmentSlot.WEAPON);
        this.weaponType = weaponType;
    }
}
