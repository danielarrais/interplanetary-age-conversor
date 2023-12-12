package dev.danielarrais.interplanetaryageconversor.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgeConversorTests {

    private static AgeConversor ageConversor;
    private static final long SECONDS = 31557600;

    @BeforeAll
    public static void setup() {
        ageConversor = new AgeConversor();
    }

    @Test
    public void convert_throwsWhenSecondsSmallerThanZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ageConversor.convert(-11, 100);
        });

        assertInstanceOf(IllegalArgumentException.class, exception);
        assertEquals("O segundo não pode ser menor ou igual a zero", exception.getMessage());
    }

    @Test
    public void convert_throwsWhenSecondsEqualZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ageConversor.convert(0, 100);
        });

        assertInstanceOf(IllegalArgumentException.class, exception);
        assertEquals("O segundo não pode ser menor ou igual a zero", exception.getMessage());
    }

    @Test
    public void convert_throwsWhenEarthAgeEqualZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ageConversor.convert(1, 0);
        });

        assertInstanceOf(IllegalArgumentException.class, exception);
        assertEquals("A quantidade de anos na terra não pode ser menor ou igual a zero", exception.getMessage());
    }

    @Test
    public void convert_throwsWhenEarthAgeThanSmallerThanZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ageConversor.convert(1, -111);
        });

        assertInstanceOf(IllegalArgumentException.class, exception);
        assertEquals("A quantidade de anos na terra não pode ser menor ou igual a zero", exception.getMessage());
    }

    @Test
    public void convert_correctForMercury() {
        AgeConversor ageConversor = new AgeConversor();
        double convertedAge = ageConversor.convert(SECONDS, PlanetsAge.MERCURY.getEarthAge());
        assertEquals(4.15, convertedAge);
    }

    @Test
    public void convert_correctForVenus() {
        AgeConversor ageConversor = new AgeConversor();
        double convertedAge = ageConversor.convert(SECONDS, PlanetsAge.VENUS.getEarthAge());
        assertEquals(1.63, convertedAge);
    }

    @Test
    public void convert_correctForEarth() {
        AgeConversor ageConversor = new AgeConversor();
        double convertedAge = ageConversor.convert(SECONDS,  PlanetsAge.EARTH.getEarthAge());
        assertEquals(1, convertedAge);
    }

    @Test
    public void convert_correctForMars() {
        AgeConversor ageConversor = new AgeConversor();
        double convertedAge = ageConversor.convert(SECONDS,  PlanetsAge.MARS.getEarthAge());
        assertEquals(0.53, convertedAge);
    }

    @Test
    public void convert_correctForJupiter() {
        AgeConversor ageConversor = new AgeConversor();
        double convertedAge = ageConversor.convert(SECONDS,  PlanetsAge.JUPITER.getEarthAge());
        assertEquals(0.08, convertedAge);
    }

    @Test
    public void convert_correctForSaturn() {
        AgeConversor ageConversor = new AgeConversor();
        double convertedAge = ageConversor.convert(SECONDS,  PlanetsAge.SATURN.getEarthAge());
        assertEquals(0.03, convertedAge);
    }

    @Test
    public void convert_correctForUranus() {
        AgeConversor ageConversor = new AgeConversor();
        double convertedAge = ageConversor.convert(SECONDS,  PlanetsAge.URANUS.getEarthAge());
        assertEquals(0.01, convertedAge);
    }

    @Test
    public void convert_correctForNeptune() {
        AgeConversor ageConversor = new AgeConversor();
        double convertedAge = ageConversor.convert(SECONDS,  PlanetsAge.NEPTUNE.getEarthAge());
        assertEquals(0.01, convertedAge);
    }
}
