package co.cactuscript.model;

public abstract class Plant {
    private Enum<PlantStatus> status = PlantStatus.HEALTHY;
    public String name;
    public String species;
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
