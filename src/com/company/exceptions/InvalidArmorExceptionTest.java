package com.company.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidArmorExceptionTest {

    @Test
    void makeSureTheExceptionWorksAsExpected(){
        String message = "An error occurred";
        Throwable expectedException = assertThrows(
                InvalidArmorException.class,
                () -> {
                    throw new InvalidArmorException(message);
                }
        );
        assertEquals(expectedException.toString(), "InvalidArmorException thrown: "+message);
    }
}