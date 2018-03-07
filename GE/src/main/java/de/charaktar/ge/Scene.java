package de.charaktar.ge;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.graphic.image.ImageContainer;
import de.charaktar.ge.metric.Dimension;

import java.util.Collections;
import java.util.List;

public class Scene {

    protected ImageContainer imageContainer;
    protected List<GameObject> gameObjects;
    protected Dimension size;

    public Scene(ImageContainer imageContainer, Dimension size, List<GameObject> gameObjects) {
        this.imageContainer = imageContainer;
        this.gameObjects = gameObjects;
        this.size = size;
    }

    protected void add(GameObject gameObject) {

        gameObject.createGraphics(this.imageContainer);
        this.gameObjects.add(gameObject);
    }

    protected void remove(GameObject gameObject) {

        this.gameObjects.remove(gameObject);
    }

    public List<GameObject> getGameObjects() {
        return Collections.unmodifiableList(this.gameObjects);
    }

}
