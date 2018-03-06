package a.test.square;

import de.charaktar.game.gameobject.GameObject;
import de.charaktar.game.graphic.Graphic;
import de.charaktar.game.graphic.image.ImageContainer;
import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;

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
