package gameobject.minion;

import gameobject.GameObject;
import metric.Dimension;
import metric.Vector;

/**
 * Created by Guido on 11.05.2016.
 */
public abstract class Minion extends GameObject {

    public Minion(Vector position) {
        super(position, new Dimension(1, 1));
    }

}
