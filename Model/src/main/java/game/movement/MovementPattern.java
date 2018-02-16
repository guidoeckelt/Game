package game.movement;

import game.gameobject.GameObject;

public abstract class MovementPattern {

    protected GameObject associatedGameObject;

    public MovementPattern(GameObject gameObject) {
        this.associatedGameObject = gameObject;
    }

    public abstract void update(MovementParameter parameter);
}
