package de.charaktar.game.movement;

import de.charaktar.game.gameobject.GameObject;

public abstract class MovementPattern {

    protected GameObject associatedGameObject;

    public MovementPattern(GameObject gameObject) {
        this.associatedGameObject = gameObject;
    }

    public abstract void update(MovementParameter parameter);
}
