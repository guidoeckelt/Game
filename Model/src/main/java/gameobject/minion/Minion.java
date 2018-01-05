package gameobject.minion;

import interfaces.Moveable;
import javafx.geometry.Dimension2D;
import gameobject.GameObject;
import metric.Vector;

/**
 * Created by Guido on 11.05.2016.
 */
public abstract class Minion extends GameObject implements Moveable {

    protected Vector moveDirection;
    protected double speed;

    public Minion(Vector position) {
        super(position, new Dimension2D(1, 1));
    }

}
