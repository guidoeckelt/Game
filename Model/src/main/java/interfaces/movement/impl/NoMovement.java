package interfaces.movement.impl;

import interfaces.movement.MovementParameter;
import interfaces.movement.MovementPattern;

public class NoMovement extends MovementPattern {

    public NoMovement() {
        super(null);
    }

    @Override
    public void update(MovementParameter parameter) {
//        this.associatedGameObject.setPosition(this.associatedGameObject.getPosition());
    }

}
