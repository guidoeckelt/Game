package game;

import a.pointyandclicky.clicky.Clicky;
import a.pointyandclicky.pointy.Pointy;
import game.gameobject.GameObject;
import game.graphic.image.ImageContainer;
import game.metric.Dimension;
import game.metric.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scene {

    protected ImageContainer imageContainer;
    protected List<GameObject> gameObjects;
    protected Dimension size;

    public Scene(ImageContainer imageContainer, Dimension size) {
        this.imageContainer = imageContainer;
        this.gameObjects = new ArrayList<>();
        this.size = size;
        this.fill();
    }

    protected void fill() {
        GameObject pointy = new Pointy(new Vector(50, 100));
        this.add(pointy);
        GameObject clicky = new Clicky(new Vector(250, 100));
        this.add(clicky);
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
