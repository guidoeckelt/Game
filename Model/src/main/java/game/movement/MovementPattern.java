package game.movement;

import game.gameobject.GameObject;

public abstract class MovementPattern<T extends GameObject> {

    protected T associatedGameObject;

    public MovementPattern(T gameObject) {
        this.associatedGameObject = gameObject;
    }

    public abstract void update(MovementParameter parameter);
}
