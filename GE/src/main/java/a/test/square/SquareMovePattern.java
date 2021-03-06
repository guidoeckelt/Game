package a.test.square;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.metric.Vector;
import de.charaktar.ge.movement.MovementParameter;
import de.charaktar.ge.movement.MovementPattern;

public class SquareMovePattern extends MovementPattern {


    private int speed;
    private Vector moveDirection;

    public SquareMovePattern(GameObject gameObject) {
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

}
