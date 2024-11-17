package co.cactuscript.model.enums;

import co.cactuscript.model.Cactus;

import java.util.Optional;

public enum Command {
    GET, SET, COMPARE;

    public static Command called (String command) throws IllegalArgumentException {
        return switch (command) {
            case "get" -> Command.GET;
            case "set" -> Command.SET;
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        };
    }

    public static Optional<?> get (Cactus cactus, Attribute attribute) {
        return switch (attribute) {
            case AGE -> Optional.of(cactus.age);
            case WATER_LEVEL -> Optional.of(cactus.waterLevel);
            case TEMPERATURE -> Optional.of(cactus.temperature);
            case HUMIDITY -> Optional.of(cactus.humidity);
            case LIGHT_LEVEL -> Optional.of(cactus.lightLevel);
            case SOIL_QUALITY -> Optional.of(cactus.soilQuality);
            case HEALTH -> Optional.of(cactus.health);
            case HAPPINESS -> Optional.of(cactus.happiness);
        };
    }

    public static boolean set(Cactus cactus, Attribute attribute, Object value) {
        try {
            switch (attribute) {
                case AGE -> cactus.age = (Integer) value;
                case WATER_LEVEL -> cactus.waterLevel = (Integer) value;
                case TEMPERATURE -> cactus.temperature = (Integer) value;
                case HUMIDITY -> cactus.humidity = (Integer) value;
                case LIGHT_LEVEL -> cactus.lightLevel = (Integer) value;
                case SOIL_QUALITY -> cactus.soilQuality = (Integer) value;
                case HEALTH -> cactus.health = (Integer) value;
                case HAPPINESS -> cactus.happiness = (Integer) value;
            };
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
