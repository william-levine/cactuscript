package co.cactuscript.exceptions;

import co.cactuscript.model.CodeBlockType;

import java.util.HashMap;
import java.util.List;

public class UnknownCodeBlockType extends Exception {
    public final List<CodeBlockType> expectedTypes;
    public UnknownCodeBlockType(String message , List<CodeBlockType> expectedTypes) {
        super(message);
        this.expectedTypes = expectedTypes;
    }
}
