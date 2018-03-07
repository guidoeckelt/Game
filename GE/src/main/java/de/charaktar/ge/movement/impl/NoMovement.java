package de.charaktar.ge.movement.impl;

import de.charaktar.ge.movement.MovementParameter;
import de.charaktar.ge.movement.MovementPattern;

public class NoMovement extends MovementPattern {

    public NoMovement() {
        super(null);
    }

    @Override
    public void update(MovementParameter parameter) {
//        this.associatedGameObject.setPosition(this.associatedGameObject.getPosition());
    }

}
