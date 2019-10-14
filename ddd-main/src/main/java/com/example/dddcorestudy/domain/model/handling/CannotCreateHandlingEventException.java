package com.example.dddcorestudy.domain.model.handling;

import java.security.PrivilegedActionException;

public class CannotCreateHandlingEventException extends Exception {

    public CannotCreateHandlingEventException() {
    }

    public CannotCreateHandlingEventException(Throwable cause) {
        super(cause);
    }

}
