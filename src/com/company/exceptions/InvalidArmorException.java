package com.company.exceptions;

public class InvalidArmorException extends Exception{
    private final String message;

    public InvalidArmorException(String message){
        this.message = message;
    }

    public String toString(){
        return "InvalidArmorException thrown: "+this.message;
    }
}
