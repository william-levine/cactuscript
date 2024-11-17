package co.cactuscript.exceptions;

import co.cactuscript.model.enums.TokenType;

import java.util.HashMap;

public class InvalidCodeStructureException extends Exception {
    public final TokenType typeReceived;
    public final String valueReceived;
    public InvalidCodeStructureException(String message, TokenType typeReceived, String valueReceived) {
        super(message);
        this.typeReceived = typeReceived;
        this.valueReceived = valueReceived;
    }
}
