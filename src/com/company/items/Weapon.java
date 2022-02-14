package com.company.items;

public class Weapon extends Item{
    private final WeaponType weaponType;
    private final double damage;
    private final double attackSpeed;

    //A subclass of Item that represents weapons, it has a WeaponType as well as damage and attack speed.
    public Weapon(String name, int requiredLevel, WeaponType weaponType, double damage, double attackSpeed){
        super(name, requiredLevel, EquipmentSlot.WEAPON);
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    //A simple getter for the WeaponType of the weapon object.
    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    //A getter that calculates and returns the DPS-value of the weapon.
    public double getDPS(){
        return this.damage * this.attackSpeed;
    }
}
