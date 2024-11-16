package co.cactuscript.model;

public abstract class Plant {
    private Enum<PlantStatus> status = PlantStatus.HEALTHY;
    private String name;
    private String species;
    private Integer age;
    private Integer waterLevel;
    private Integer temperature;
    private Integer humidity;
    private Integer lightLevel;
    private Integer soilQuality;
    private Integer health;
    private Integer happiness;
    private double growthRate;
    private double waterDrainRate;
    private double temperatureRate;
    private double humidityRate;
    private double lightRate;

    public Plant(String name, String species, Integer waterLevel, Integer temperature, Integer humidity, Integer lightLevel, Integer soilQuality, double growthRate, Integer health, Integer happiness,  double waterDrainRate, double temperatureRate, double humidityRate, double lightRate) {
        this.name = name;
        this.species = species;
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
