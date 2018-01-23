package game;

import game.metric.Dimension;
import game.metric.Vector;

public class Camera {


    private Vector position;
    private Dimension viewport;

    public Camera(Vector position, Dimension viewport) {
        this.position = position;
        this.viewport = viewport;
    }
}
