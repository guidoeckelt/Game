package de.charaktar.ge.gameobject;

import de.charaktar.ge.graphic.Drawable;
import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.NoGraphic;
import de.charaktar.ge.graphic.image.ImageContainer;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;
import de.charaktar.ge.movement.MovementParameter;
import de.charaktar.ge.movement.MovementPattern;
import de.charaktar.ge.movement.impl.NoMovement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guido on 05.05.2016.
 */
public abstract class GameObject implements Drawable {

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
