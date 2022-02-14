package com.company.exceptions;

import com.company.exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidWeaponExceptionTest {

    @Test
    void makeSureTheExceptionWorksAsExpected(){
        String message = "An error occurred";
        Throwable expectedException = assertThrows(
                InvalidWeaponException.class,
                () -> {
                    throw new InvalidWeaponException(message);
                }
        );
        assertEquals(expectedException.toString(), "InvalidWeaponException thrown: "+message);
    }
}