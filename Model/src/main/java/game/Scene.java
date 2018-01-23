package game;

import game.Graphic.ImageContainer;
import game.gameobject.GameObject;
import game.gameobject.TestImageGameObject;
import game.gameobject.TestSpriteGameObject;
import game.gameobject.square.Square;
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
        GameObject square = new Square(new Vector(50, 50), new Dimension(20, 20));
        this.add(square);
        GameObject gameObject = new TestImageGameObject(new Vector(50, 150), new Dimension(20, 20));
        this.add(gameObject);
        int scale = 5;
        GameObject gameObject2 = new TestSpriteGameObject(new Vector(150, 150), new Dimension(30 * scale, 19 * scale));
        this.add(gameObject2);
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
