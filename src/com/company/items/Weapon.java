package com.company.items;

public class Weapon extends Item{
    private final WeaponType weaponType;
    private final double damage;
    private final double attackSpeed;

    public Weapon(String name, int requiredLevel, WeaponType weaponType, double damage, double attackSpeed){
        super(name, requiredLevel, EquipmentSlot.WEAPON);
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    public double getDPS(){
        return this.damage * this.attackSpeed;
    }
}
