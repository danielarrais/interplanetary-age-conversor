package dev.danielarrais.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import dev.danielarrais.interplanetaryageconversor.domain.PlanetsAge;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties()
public class AgeConverterRequest {

    @NotNull
    private Long seconds;

    @NotNull
    private PlanetsAge planet;

    public Long getSeconds() {
        return seconds;
    }

    @JsonValue
    public void setSeconds(Long seconds) {
        this.seconds = seconds;
    }

    public PlanetsAge getPlanet() {
        return planet;
    }

    @JsonValue
    public void setPlanet(String planet) {
        this.planet = PlanetsAge.getPlanetAgeByName(planet);
    }
}
