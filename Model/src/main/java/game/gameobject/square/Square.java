package game.gameobject.square;

import game.Graphic.Graphic;
import game.Graphic.ImageContainer;
import game.gameobject.GameObject;
import game.metric.Dimension;
import game.metric.Vector;

/**
 * Created by Guido on 11.05.2016.
 */
public class Square extends GameObject {

    public Square(Vector position, Dimension size) {
        super(position, size);
        this.movementPattern = new SquareMovePattern(this);

    }

    @Override
    public void createGraphics(ImageContainer imageContainer) {
        Graphic graphic = new SquareGraphic(this);
        this.graphics.add(graphic);
    }

}
