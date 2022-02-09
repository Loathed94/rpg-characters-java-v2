package com.company;

public abstract class CharacterClass {
    private final String NAME;
    private int level = 1;

    public CharacterClass(String name){
        this.NAME = name;
    }
}
