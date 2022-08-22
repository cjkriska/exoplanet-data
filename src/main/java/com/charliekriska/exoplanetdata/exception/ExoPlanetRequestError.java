package com.charliekriska.exoplanetdata.exception;

public class ExoPlanetRequestError {

    private final Class<?> exception;
    private final String message;

    public ExoPlanetRequestError(Exception exception) {
        this.exception = exception.getClass();
        this.message = exception.getLocalizedMessage();
    }

    public String getMessage() {
        return message;
    };

    public String getException() {
        return exception.getCanonicalName();
    }

}
