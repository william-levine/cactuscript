package co.cactuscript.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Cactus {
    private Enum<CactusStatus> status = CactusStatus.HEALTHY;
    public Integer age;
    public Integer waterLevel;
    public Integer temperature;
    public Integer humidity;
    public Integer lightLevel;
    public Integer soilQuality;
    public Integer health;
    public Integer happiness;
    private Double growthRate;
    private double waterDrainRate;
    private double temperatureRate;
    private double humidityRate;
    private double lightRate;

    private int height;

    public Cactus () {
        this.age = 0;
        this.waterLevel = 100;
        this.temperature = 25;
        this.humidity = 50;
        this.lightLevel = 50;
        this.soilQuality = 100;
        this.growthRate = 0.5;
        this.health = 100;
        this.happiness = 12;
        this.waterDrainRate = 0.5;
        this.temperatureRate = 0.5;
        this.humidityRate = 0.5;
        this.lightRate = 0.5;
    }

    public Cactus (Integer age, Integer waterLevel, Integer temperature, Integer humidity, Integer lightLevel, Integer soilQuality, Integer health, Integer happiness) {
        this.age = age == null ? 0 : age;
        this.waterLevel = waterLevel == null ? 100 : waterLevel;
        this.temperature = temperature == null ? 25 : temperature;
        this.humidity = humidity == null ? 50 : humidity;
        this.lightLevel = lightLevel == null ? 50 : lightLevel;
        this.soilQuality = soilQuality == null ? 100 : soilQuality;
        this.health = health == null ? 100 : health;
        this.happiness = happiness == null ? 100 : happiness;
        this.waterDrainRate = 0.5;
        this.temperatureRate = 0.5;
        this.humidityRate = 0.5;
        this.lightRate = 0.5;
    }

    public Cactus (Integer waterLevel, Integer temperature, Integer humidity, Integer lightLevel, Integer soilQuality, double growthRate, Integer health, Integer happiness,  double waterDrainRate, double temperatureRate, double humidityRate, double lightRate) {
        this.age = 0;
        this.waterLevel = waterLevel;
        this.temperature = temperature;
        this.humidity = humidity;
        this.lightLevel = lightLevel;
        this.soilQuality = soilQuality;
        this.growthRate = growthRate;
        this.health = health;
        this.happiness = happiness;
        this.waterDrainRate = waterDrainRate;
        this.temperatureRate = temperatureRate;
        this.humidityRate = humidityRate;
        this.lightRate = lightRate;
    }

    public Map<String, Object> serialise() throws RuntimeException {
        Map<String, Object> attributes = new HashMap<>();
        Field[] validFields = this.getClass().getFields();
        for (Field field : validFields) {
            try {
                attributes.put(field.getName(), field.get(this));
            } catch (IllegalAccessException | NullPointerException e) {
                throw new RuntimeException("Failed to serialise cactus");
            }
        }
        return attributes;
    }

    public static Cactus fromSerialised(Map<String, Integer> attributes) {
        return new Cactus(
            (Integer) attributes.get("age"),
            (Integer) attributes.get("waterLevel"),
            (Integer) attributes.get("temperature"),
            (Integer) attributes.get("humidity"),
            (Integer) attributes.get("lightLevel"),
            (Integer) attributes.get("soilQuality"),
            (Integer) attributes.get("health"),
            (Integer) attributes.get("happiness")
        );
    }
}
