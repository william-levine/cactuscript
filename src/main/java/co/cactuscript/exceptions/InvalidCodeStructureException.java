package co.cactuscript.exceptions;

import co.cactuscript.model.CodeBlockType;

import java.util.HashMap;

public class InvalidCodeStructureException extends Exception {
    public final CodeBlockType typeReceived;
    public final String valueReceived;
    public InvalidCodeStructureException(String message, CodeBlockType typeReceived, String valueReceived) {
        super(message);
        this.typeReceived = typeReceived;
        this.valueReceived = valueReceived;
    }
}
