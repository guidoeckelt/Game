package game.gameobject;

import game.metric.Dimension;
import game.metric.Vector;

public class NullGameObject extends GameObject {

    public NullGameObject() {
        super(new Vector(0, 0, 0), new Dimension(0, 0, 0));
    }

}
