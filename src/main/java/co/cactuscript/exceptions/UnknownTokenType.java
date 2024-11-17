package co.cactuscript.exceptions;

import co.cactuscript.model.enums.TokenType;

import java.util.HashMap;
import java.util.List;

public class UnknownTokenType extends Exception {

    public final List<TokenType> expectedTypes;
    public UnknownTokenType(String message , List<TokenType> expectedTypes) {
        super(message);
        this.expectedTypes = expectedTypes;
    }
}
