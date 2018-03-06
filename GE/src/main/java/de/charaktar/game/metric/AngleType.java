package de.charaktar.game.metric;

public enum AngleType {
    RADIANS("rad"),
    DEGREE("deg");

    private final String value;

    AngleType(String value) {
        this.value = value;
    }
}
