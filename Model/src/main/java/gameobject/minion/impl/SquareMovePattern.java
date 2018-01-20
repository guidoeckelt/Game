package gameobject.minion.impl;

import gameobject.GameObject;
import interfaces.movement.MovementParameter;
import interfaces.movement.MovementPattern;
import metric.Vector;

import java.util.List;

public class SquareMovePattern extends MovementPattern<Square> {


    private int speed;
    private Vector moveDirection;

    public SquareMovePattern(Square gameObject) {
        super(gameObject);
        this.moveDirection = new Vector(1, 0).normalized();
        this.speed = 1;
    }

    @Override
    public void update(MovementParameter moveParameter) {
        Vector positionDifference = this.moveDirection.multipliedBy(this.speed);
        Vector newPosition = this.associatedGameObject.getPosition().add(positionDifference);
        this.associatedGameObject.setPosition(newPosition);

    }

    private GameObject checkForIntersectionWith(List<GameObject> gameObjects) {
        for (GameObject gameObject : gameObjects) {
            if (this.associatedGameObject != gameObject && this.associatedGameObject.intersects(gameObject)) {
                return gameObject;
            }
        }
        return null;
    }
}
