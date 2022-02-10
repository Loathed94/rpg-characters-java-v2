package com.company.items;

public class Weapon extends Item{
    private final WeaponType weaponType;
    private final int damage;
    private final int attackSpeed;

    public Weapon(String name, int requiredLevel, WeaponType weaponType, int damage, int attackSpeed){
        super(name, requiredLevel, EquipmentSlot.WEAPON);
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    public int getDPS(){
        return this.damage * this.attackSpeed;
    }
}
