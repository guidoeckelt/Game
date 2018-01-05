package metric;

/**
 * Created by Guido on 05.05.2016.
 */
public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y){
        this(x, y, 0d);
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double length() {

        double length = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));

        return length;
    }

    public Vector normalized() {
        double length = length();

        Vector normalizedVector = new Vector(this.x / length, this.y / length);

        return normalizedVector;
    }

    public Vector substract(Vector Position) {

        double X = this.x - Position.getX();
        double Y = this.y - Position.getY();

        Vector substractedVector = new Vector(X, Y);

        return substractedVector;
    }

    public Vector add(Vector Position) {
        double X = this.x + Position.getX();
        double Y = this.y + Position.getY();

        Vector addedVector = new Vector(X, Y);

        return addedVector;
    }

    public Vector add(double summand) {

        Vector addedVector = new Vector(this.x + summand, this.y + summand);

        return addedVector;
    }

    public Vector multipliedBy(double multiplier) {
        Vector multipliedVector = new Vector(this.x * multiplier, this.y * multiplier);

        return multipliedVector;
    }

    @Override
    public String toString() {

        String stringed = "(x = " + this.x + " | y = " + this.y + ")";

        return stringed;
    }
}
