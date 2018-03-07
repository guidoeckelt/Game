package de.charaktar.ge.metric;


/**
 * Created by Guido on 05.05.2016.
 */
public class Vector {

    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y) {
        this(x, y, 0d);
    }

    public Vector(Vector vector) {
        this(vector.getX(), vector.getY(), vector.getZ());
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double length() {

        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public Vector normalized() {

        double length = length();
        double newX = this.x / length;
        double newY = this.y / length;
        double newZ = this.z / length;
        return new Vector(newX, newY, newZ);
    }

    public Vector substract(Vector position) {

        double newX = this.x - position.getX();
        double newY = this.y - position.getY();
        double newZ = this.z - position.getZ();
        return new Vector(newX, newY, newZ);
    }

    public Vector add(Vector position) {

        double newX = this.x + position.getX();
        double newY = this.y + position.getY();
        double newZ = this.z + position.getZ();
        return new Vector(newX, newY, newZ);
    }

    public Vector add(double summand) {

        double newX = this.x + summand;
        double newY = this.y + summand;
        double newZ = this.z + summand;
        return new Vector(newX, newY, newZ);
    }

    public Vector multipliedBy(double multiplier) {

        double newX = this.x * multiplier;
        double newY = this.y * multiplier;
        double newZ = this.z * multiplier;
        return new Vector(newX, newY, newZ);
    }

    @Override
    public String toString() {

        return "(x = " + this.x + " | y = " + this.y + " | z = " + this.z + " )";
    }
}
