package game.movement;

import game.gameobject.GameObject;
import game.metric.Dimension;

import java.util.List;

/**
 * Created by Guido on 12.05.2016.
 */
public class MovementParameter {

    private Dimension gridSize;
    private List<GameObject> gameObjects;

    public MovementParameter(List<GameObject> gameObjects) {
        this.gridSize = gridSize;
        this.gameObjects = gameObjects;
    }

    public Dimension getGridSize() {
        return gridSize;
    }

    public void setGridSize(Dimension gridSize) {
        this.gridSize = gridSize;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }
}
