package de.charaktar.ge.movement;

import de.charaktar.ge.gameobject.GameObject;

public abstract class MovementPattern {

    protected GameObject associatedGameObject;

    public MovementPattern(GameObject gameObject) {
        this.associatedGameObject = gameObject;
    }

    public abstract void update(MovementParameter parameter);
}
