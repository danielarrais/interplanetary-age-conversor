package dev.danielarrais.interplanetaryageconversor.domain;


public class AgeConversor {
    private final double EARTH_YEAR_SECONDS = 31557600.0;

    public Double convert(long seconds, double earthAge) {
        validateAge(seconds);
        validateEarthAge(earthAge);

        double yearsEarth = seconds / EARTH_YEAR_SECONDS;
        double age = yearsEarth / earthAge;

        return roundForTwoDecimals(age);
    }

    private Double roundForTwoDecimals(Double value) {
        if (value <= 0) return 0.00;
        return Math.round(value * 100.0) / 100.0;
    }

    private void validateAge(Long seconds) {
        if (seconds <= 0) throw new IllegalArgumentException("O segundo não pode ser menor ou igual a zero");
    }

    private void validateEarthAge(double earthAge) {
        if (earthAge <= 0) throw new IllegalArgumentException("A quantidade de anos na terra não pode ser menor ou igual a zero");
    }
}
