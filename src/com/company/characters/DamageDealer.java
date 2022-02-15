package com.company.characters;

public interface DamageDealer {

    //getter for DPS, each class that implements it will have its own definition and calculation of what value will be returned.
    //Implemented in classes describing characters that are supposed to be able to deal damage in combat.

    public double getDPS();
}
