package util;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by Guido on 14.05.2016.
 */
public class DrawParameters {
    private final GraphicsContext context;
    private final double fieldSize;

    public DrawParameters(GraphicsContext context, double fieldSize) {
        this.context = context;
        this.fieldSize = fieldSize;
    }

    public GraphicsContext getContext() {
        return context;
    }

    public double getFieldSize() {
        return fieldSize;
    }
}
