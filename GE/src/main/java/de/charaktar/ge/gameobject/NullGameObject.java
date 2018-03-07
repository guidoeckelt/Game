package de.charaktar.ge.gameobject;

import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

public class NullGameObject extends GameObject {

    public NullGameObject() {
        super(new Vector(0, 0, 0), new Dimension(0, 0, 0));
    }

}
