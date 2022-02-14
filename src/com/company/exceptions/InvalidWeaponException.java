package com.company.exceptions;

public class InvalidWeaponException extends Exception{
    private final String message;

    public InvalidWeaponException(String message){
        this.message = message;
    }

    public String toString(){
        return "InvalidWeaponException thrown: "+this.message;
    }
}
