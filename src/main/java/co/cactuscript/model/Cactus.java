package co.cactuscript.model;

public class Cactus {
    private Enum<CactusStatus> status = CactusStatus.HEALTHY;
    public String name;
    public Integer age;
    public Integer waterLevel;
    public Integer temperature;
    public Integer humidity;
    public Integer lightLevel;
    public Integer soilQuality;
    public Integer health;
    public Integer happiness;
    private double growthRate;
    private double waterDrainRate;
    private double temperatureRate;
    private double humidityRate;
    private double lightRate;

    private int height;

    public Cactus (String name) {
        this.name = name;
        this.age = 0;
        this.waterLevel = 100;
        this.temperature = 25;
        this.humidity = 50;
        this.lightLevel = 50;
        this.soilQuality = 100;
        this.growthRate = 0.5;
        this.health = 100;
        this.happiness = 100;
        this.waterDrainRate = 0.5;
        this.temperatureRate = 0.5;
        this.humidityRate = 0.5;
        this.lightRate = 0.5;
    }

    public Cactus (String name, String species, Integer waterLevel, Integer temperature, Integer humidity, Integer lightLevel, Integer soilQuality, double growthRate, Integer health, Integer happiness,  double waterDrainRate, double temperatureRate, double humidityRate, double lightRate) {
        this.name = name;
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
}
