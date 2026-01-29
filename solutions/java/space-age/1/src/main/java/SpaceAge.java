import java.util.Map;

class SpaceAge {

    private double seconds;
    private static final double SECONDS_IN_EARTH_YEAR = 31_557_600;
    private static final Map<String, Double> ORBITAL_PERIOD = Map.of("Mercury", 0.2408467,
                                                                      "Venus", 0.61519726,
                                                                      "Earth", 1.0,
                                                                      "Mars", 1.8808158,
                                                                      "Jupiter", 11.862615,
                                                                      "Saturn", 29.447498,
                                                                      "Uranus", 84.016846,
                                                                      "Neptune", 164.79132);
    
    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return seconds / ORBITAL_PERIOD.get("Earth") / SECONDS_IN_EARTH_YEAR;
    }

    double onMercury() {
        return seconds / ORBITAL_PERIOD.get("Mercury") / SECONDS_IN_EARTH_YEAR;
    }

    double onVenus() {
        return seconds / ORBITAL_PERIOD.get("Venus") / SECONDS_IN_EARTH_YEAR;
    }

    double onMars() {
        return seconds / ORBITAL_PERIOD.get("Mars") / SECONDS_IN_EARTH_YEAR;
    }

    double onJupiter() {
        return seconds / ORBITAL_PERIOD.get("Jupiter") / SECONDS_IN_EARTH_YEAR;
    }

    double onSaturn() {
        return seconds / ORBITAL_PERIOD.get("Saturn") / SECONDS_IN_EARTH_YEAR;
    }

    double onUranus() {
        return seconds / ORBITAL_PERIOD.get("Uranus") / SECONDS_IN_EARTH_YEAR;
    }

    double onNeptune() {
        return seconds / ORBITAL_PERIOD.get("Neptune") / SECONDS_IN_EARTH_YEAR;
    }

}
