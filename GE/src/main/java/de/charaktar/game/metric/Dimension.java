package de.charaktar.game.metric;

public class Dimension {

    private final double width;
    private final double height;
    private final double depth;

    public Dimension(double width, double height) {
        this(width, height, 0d);
    }

    public Dimension(Dimension dimension) {
        this(dimension.getWidth(), dimension.getWidth(), dimension.getDepth());
    }

    public Dimension(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }
}
