package dev.danielarrais.interplanetaryageconversor.service;

import dev.danielarrais.interplanetaryageconversor.domain.AgeConversor;
import dev.danielarrais.interplanetaryageconversor.domain.PlanetsAge;

public class AgeConverter {
    private final AgeConversor ageConversor;

    public AgeConverter(AgeConversor ageConversor) {
        this.ageConversor = ageConversor;
    }

    public double convert(long seconds, PlanetsAge planetAge) {
        if (planetAge == null) throw  new IllegalArgumentException("o atributo planetAge não pode ser nulo");
        return ageConversor.convert(seconds, planetAge.getEarthAge());
    }
}
