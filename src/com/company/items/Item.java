package com.company.items;

public abstract class Item {
    private final String name;
    private final int requiredLevel;
    private final EquipmentSlot equipmentSlot;

    public Item(String name, int requiredLevel, EquipmentSlot equipmentSlot){
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.equipmentSlot = equipmentSlot;
    }

    public String getName() {
        return this.name;
    }

    public int getRequiredLevel() {
        return this.requiredLevel;
    }

    public EquipmentSlot getEquipmentSlot() {
        return this.equipmentSlot;
    }
}
