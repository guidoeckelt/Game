package de.charaktar.game.movement.impl;

import de.charaktar.game.movement.MovementParameter;
import de.charaktar.game.movement.MovementPattern;

public class NoMovement extends MovementPattern {

    public NoMovement() {
        super(null);
    }

    @Override
    public void update(MovementParameter parameter) {
//        this.associatedGameObject.setPosition(this.associatedGameObject.getPosition());
    }

}
