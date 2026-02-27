package com.tracemeds.indent_service.exception;

public class UnregisteredTenantException extends RuntimeException {
    public UnregisteredTenantException(String message) {
        super(message);
    }
}
