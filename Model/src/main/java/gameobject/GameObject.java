package gameobject;

import game.Graphic.Graphic;
import game.Graphic.NoGraphic;
import interfaces.movement.MovementParameter;
import interfaces.movement.MovementPattern;
import interfaces.movement.impl.NoMovement;
import metric.Dimension;
import metric.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guido on 05.05.2016.
 */
public abstract class GameObject {

    protected Vector position;
    protected Dimension size;
    protected MovementPattern movementPattern;
    protected List<Graphic> graphics;

    public GameObject(Vector position, Dimension size) {

        this.position = position;
        this.size = size;
        this.movementPattern = new NoMovement();
        this.graphics = new ArrayList<>();

    }

    public void createGraphics() {

        this.graphics.add(new NoGraphic());
    }

    public Graphic currentGraphic() {

        return this.graphics.get(0);
    }

    public void update(MovementParameter moveInfo) {

        this.movementPattern.update(moveInfo);
    }

    public boolean intersects(GameObject gameObject) {

//        System.out.println(this.position.getX()+" :: "+(gameObject.getPosition().getX()+gameObject.getSize().getWidth()));
//        System.out.println(this.position.getY()+" :: "+(gameObject.getPosition().getY()+gameObject.getSize().getHeight()));
        if (this.position.getX() <= gameObject.getPosition().getX() + gameObject.getSize().getWidth() &&
                this.position.getX() + this.size.getWidth() >= gameObject.getPosition().getX()) {
            if (this.position.getY() <= gameObject.getPosition().getY() + gameObject.getSize().getHeight() &&
                    this.position.getY() + this.size.getHeight() >= gameObject.getPosition().getY()) {
                return true;
            }
        }
        return false;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

}
