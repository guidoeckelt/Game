package game.movement.impl;

import game.movement.MovementParameter;
import game.movement.MovementPattern;

public class NoMovement extends MovementPattern {

    public NoMovement() {
        super(null);
    }

    @Override
    public void update(MovementParameter parameter) {
//        this.associatedGameObject.setPosition(this.associatedGameObject.getPosition());
    }

}
