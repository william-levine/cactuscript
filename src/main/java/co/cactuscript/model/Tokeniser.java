package co.cactuscript.model;

import co.cactuscript.exceptions.InvalidCodeStructureException;
import co.cactuscript.exceptions.UnknownTokenType;
import co.cactuscript.model.enums.Attribute;
import co.cactuscript.model.enums.Command;
import co.cactuscript.model.enums.Terminator;
import co.cactuscript.model.enums.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Tokeniser {
    public static List<Token<?>> tokenise(List<String> tokenStrings) throws InvalidCodeStructureException, UnknownTokenType {
        List<Token<?>> tokenList = new ArrayList<>();

        List<TokenType> validNextTypes = new ArrayList<>(Arrays.asList(TokenType.COMMAND, TokenType.TERMINATOR));

        for (String token : tokenStrings) {
            try {
                Token<?> classifiedToken = classifyToken(token);
                TokenType type = classifiedToken.getType();

                if(validNextTypes.contains(type)) {
                    validNextTypes = TokenType.getValidNextTypes(type);
                    tokenList.add(classifyToken(token));
                } else {
                    throw new InvalidCodeStructureException("Invalid token", type, token);
                }
            } catch (IllegalArgumentException e) {
                throw new UnknownTokenType("Unknown token type", validNextTypes);
            }
        }

        return tokenList;
    }

    private static Token<?> classifyToken(String token) throws IllegalArgumentException {
        // Check for commands
        for (Command command : Command.values()) {
            if (command.name().equalsIgnoreCase(token)) {
                return new Token<>(TokenType.COMMAND, command);
            }
        }

        // Check for attributes
        for (Attribute attribute : Attribute.values()) {
            if (attribute.name().equalsIgnoreCase(token)) {
                return new Token<>(TokenType.ATTRIBUTE, attribute);
            }
        }

        // Check for terminators
        for (Terminator terminator : Terminator.values()) {
            if (terminator.name().equalsIgnoreCase(token)) {
                return new Token<>(TokenType.TERMINATOR, terminator);
            }
        }

        // Fallback to unknown attribute
        throw new IllegalArgumentException("Unknown token: " + token);
    }
}
