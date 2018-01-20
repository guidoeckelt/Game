package gameobject.minion.impl;

import game.Graphic.Graphic;
import gameobject.GameObject;
import gameobject.minion.Minion;
import metric.Vector;

import java.util.List;

/**
 * Created by Guido on 11.05.2016.
 */
public class Square extends Minion {

    public Square(Vector position) {
        super(position);
        this.movementPattern = new SquareMovePattern(this);
//        this.graphics = new SquareGraphic(this);

    }

    @Override
    public void createGraphics() {
        Graphic graphic = new SquareGraphic(this);
        this.graphics.add(graphic);
    }

    @Override
    public Graphic currentGraphic() {
        return this.graphics.get(0);
    }

    private GameObject checkForIntersectionWith(List<GameObject> gameObjects) {
        for (GameObject gameObject : gameObjects) {
            if (this != gameObject && this.intersects(gameObject)) {
                return gameObject;
            }
        }
        return null;
    }

}
