package com.company.items;

public abstract class Item {
    private final String NAME;
    private final int REQUIRED_LEVEL;
    private final String EQUIPMENT_SLOT;

    public Item(String name, int requiredLevel, String equipmentSlot){
        this.NAME = name;
        this.REQUIRED_LEVEL = requiredLevel;
        this.EQUIPMENT_SLOT = equipmentSlot;
    }
}
