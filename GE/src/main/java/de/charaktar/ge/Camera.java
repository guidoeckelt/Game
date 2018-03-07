package de.charaktar.ge;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

public class Camera {


    private Vector position;
    private Dimension viewport;

    public Camera(Vector position, Dimension viewport) {
        this.position = position;
        this.viewport = viewport;
    }

    public boolean isGameObjectVisible(GameObject gameObject) {
        if (gameObject.getPosition().getX() + gameObject.getSize().getWidth() > this.position.getX()) {
            return true;
        }
        if (gameObject.getPosition().getX() < this.position.getX() + this.viewport.getWidth()) {
            return true;
        }

        if (gameObject.getPosition().getY() + gameObject.getSize().getHeight() > this.position.getY()) {
            return true;
        }
        if (gameObject.getPosition().getY() < this.position.getY() + this.viewport.getHeight()) {
            return true;
        }
        return false;
    }

    public Dimension getViewport() {
        return viewport;
    }
}
