package a.test.square;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.image.ImageContainer;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

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
