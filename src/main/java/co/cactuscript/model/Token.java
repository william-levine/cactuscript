package co.cactuscript.model;

import co.cactuscript.model.enums.TokenType;

import java.util.List;

public class Token<T> {
    private final TokenType type;
    private final T value;

    public Token(TokenType type, T value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
