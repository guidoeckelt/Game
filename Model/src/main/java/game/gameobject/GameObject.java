package game.gameobject;

import game.graphic.Graphic;
import game.graphic.NoGraphic;
import game.graphic.image.ImageContainer;
import game.metric.Dimension;
import game.metric.Vector;
import game.movement.MovementParameter;
import game.movement.MovementPattern;
import game.movement.impl.NoMovement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guido on 05.05.2016.
 */
public abstract class GameObject implements game.graphic.Drawable {

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

    @Override
    public void createGraphics(ImageContainer imageContainer) {

        this.graphics.add(new NoGraphic());
    }

    @Override
    public Graphic currentGraphic() {

        return this.graphics.get(0);
    }

    public void update(MovementParameter moveInfo) {

        this.movementPattern.update(moveInfo);
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

    public String getName() {
        return this.toString();
    }

}
