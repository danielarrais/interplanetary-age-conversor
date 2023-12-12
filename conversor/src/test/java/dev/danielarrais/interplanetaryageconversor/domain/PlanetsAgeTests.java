package dev.danielarrais.interplanetaryageconversor.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlanetsAgeTests {
    @Test
    public void getPlanetAgeByName_throwsWhenThePlanetAgeNameIsInvalid() {
        String invalidPlanetName = "sdflkajsdf";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PlanetsAge.getPlanetAgeByName(invalidPlanetName);
        });

        assertInstanceOf(IllegalArgumentException.class, exception);
        assertEquals("O planeta " + invalidPlanetName + " não existe", exception.getMessage());
    }

    @Test
    public void getPlanetAgeByName_successGetWhenThePlanetNameIsValid() {
        String[] planets = new String[]{"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};

        for (String planet : planets) {
            assertNotNull(PlanetsAge.getPlanetAgeByName(planet));
        }
    }
}
