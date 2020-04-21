package com.inti.formation.shop.api.rest.exception;

/**
 * @author Sylvanius Kouandongui
 */
public class ValidationParameterException extends Throwable {

    public ValidationParameterException(final String message) {
        super(message);
    }
    public ValidationParameterException(final String message, final Throwable cause)
    {
        super(message, cause);
    }
}
