package com.kagotsi.katabank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <pre>
 * Title: KataBankException class
 * Description: KataBankException
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class KataBankException extends RuntimeException {
    public KataBankException(String message) {
        super(message);
    }
    public KataBankException(String message, Throwable cause) {
        super(message, cause);
    }
}
