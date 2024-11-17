package co.cactuscript.model.enums;

public enum Command {
    GET, SET, COMPARE;

    public static Command called (String command) throws IllegalArgumentException {
        return switch (command) {
            case "get" -> Command.GET;
            case "set" -> Command.SET;
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        };
    }
}
