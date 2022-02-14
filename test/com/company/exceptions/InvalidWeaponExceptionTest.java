package com.company.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class InvalidWeaponExceptionTest {

    @Test
    void TestInvalidWeaponException_ThrowException_ExceptionIsThrown(){
        String message = "An error occurred";
        Throwable expectedException = Assertions.assertThrows(
                InvalidWeaponException.class,
                () -> {
                    throw new InvalidWeaponException(message);
                }
        );
        String expectedExceptionMessage = "InvalidWeaponException thrown: "+message;
        String actualExceptionMessage = expectedException.toString();

        Assertions.assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }
}