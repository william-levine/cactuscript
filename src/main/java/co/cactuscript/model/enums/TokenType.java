package co.cactuscript.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum TokenType {
    COMMAND, ATTRIBUTE, VALUE, TERMINATOR;

    public static ArrayList<TokenType> getValidNextTypes(TokenType type) {
        return switch (type) {
            case COMMAND -> new ArrayList<>(List.of(ATTRIBUTE));
            case ATTRIBUTE -> new ArrayList<>(List.of(VALUE, TERMINATOR));
            case VALUE -> new ArrayList<>(List.of(TERMINATOR));
            case TERMINATOR -> new ArrayList<>(List.of(COMMAND));
        };
    }
}
