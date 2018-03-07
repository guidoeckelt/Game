package de.charaktar.ge.metric;

public class Angle {

    private final double value;
    private final AngleType type;

    public Angle(double value, AngleType type) {
        this.value = value;
        this.type = type;
    }


    public Angle radians() {
        double newValue;
        if (this.type == AngleType.DEGREE) {
            newValue = this.value * (Math.PI / 180);
        } else {
            newValue = this.value;
        }
        return new Angle(newValue, AngleType.RADIANS);
    }

    public Angle degree() {
        double newValue;
        if (this.type == AngleType.RADIANS) {
            newValue = this.value * (180 / Math.PI);
        } else {
            newValue = this.value;
        }
        return new Angle(newValue, AngleType.DEGREE);
    }
}
