package com.rokibrucse.exceptionvalidation.exception;

public class UniqueFieldException extends Exception{
    public UniqueFieldException() {
        super();
    }

    public UniqueFieldException(String message) {
        super(message);
    }

    public UniqueFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniqueFieldException(Throwable cause) {
        super(cause);
    }

    protected UniqueFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
