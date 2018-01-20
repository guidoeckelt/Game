package gameobject;

import metric.Dimension;
import metric.Vector;

public class NullGameObject extends GameObject {

    public NullGameObject() {
        super(new Vector(0, 0, 0), new Dimension(0, 0, 0));
    }

}
