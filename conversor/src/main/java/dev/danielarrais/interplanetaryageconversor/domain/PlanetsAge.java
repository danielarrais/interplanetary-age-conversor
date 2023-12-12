package dev.danielarrais.interplanetaryageconversor.domain;

public enum PlanetsAge {
    MERCURY("mercury", 0.2408467),
    VENUS("venus", 0.61519726),
    EARTH("earth", 1.0),
    MARS("mars", 1.8808158),
    JUPITER("jupiter", 11.862615),
    SATURN("saturn", 29.447498),
    URANUS("uranus", 84.016846),
    NEPTUNE("neptune", 164.79132);

    private final String name;
    private final double earthAge;

    PlanetsAge(String name, double earthAge) {
        this.name = name;
        this.earthAge = earthAge;
    }

    public String getName() {
        return name;
    }

    public double getEarthAge() {
        return earthAge;
    }

    public static PlanetsAge getPlanetAgeByName(String planetName) {
        for (PlanetsAge value : PlanetsAge.values()) {
            if (value.getName().equals(planetName)) return value;
        }

        throw new IllegalArgumentException("O planeta " + planetName + " não existe");
    }
}
