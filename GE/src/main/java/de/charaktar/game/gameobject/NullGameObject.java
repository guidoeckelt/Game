package de.charaktar.game.gameobject;

import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;

public class NullGameObject extends GameObject {

    public NullGameObject() {
        super(new Vector(0, 0, 0), new Dimension(0, 0, 0));
    }

}
