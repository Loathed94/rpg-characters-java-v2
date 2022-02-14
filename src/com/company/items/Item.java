package com.company.items;

public abstract class Item {
    private final String name;
    private final int requiredLevel;
    private final EquipmentSlot equipmentSlot;

    //An abstract superclass for different item classes. Stores the shared data and methods for its subclasses.
    public Item(String name, int requiredLevel, EquipmentSlot equipmentSlot){
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.equipmentSlot = equipmentSlot;
    }

    //A simple getter for the name of the item.
    public String getName() {
        return this.name;
    }

    //A simple getter for the required level to use item.
    public int getRequiredLevel() { return this.requiredLevel; }

    //A simple getter for the EquipmentSlot for the item.
    public EquipmentSlot getEquipmentSlot() {
        return this.equipmentSlot;
    }
}
