package com.company.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class InvalidArmorExceptionTest {

    @Test
    void TestInvalidArmorException_ThrowException_ExceptionIsThrown(){
        String message = "An error occurred";
        Throwable expectedException = Assertions.assertThrows(
                InvalidArmorException.class,
                () -> {
                    throw new InvalidArmorException(message);
                }
        );
        String expectedExceptionMessage = "InvalidArmorException thrown: "+message;
        String actualExceptionMessage = expectedException.toString();
        Assertions.assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }
}