package com.company.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class InvalidArmorExceptionTest {

    @Test
    void TestInvalidArmorException_ThrowException_ExceptionIsThrown(){
        String expectedExceptionMessage = "InvalidArmorException thrown: An error occurred";
        Throwable expectedException = Assertions.assertThrows(
                InvalidArmorException.class,
                () -> {
                    throw new InvalidArmorException(expectedExceptionMessage);
                }
        );
        String actualExceptionMessage = expectedException.toString();
        Assertions.assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }
}