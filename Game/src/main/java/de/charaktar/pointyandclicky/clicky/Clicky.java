package de.charaktar.pointyandclicky.clicky;

import de.charaktar.game.gameobject.GameObject;
import de.charaktar.game.graphic.Graphic;
import de.charaktar.game.graphic.image.ImageContainer;
import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;

public class Clicky extends GameObject {

    public Clicky(Vector position) {
        super(position, new Dimension(200, 200));
//        this.movementPattern = new SquareMovePattern(this);

    }

    @Override
    public void createGraphics(ImageContainer imageContainer) {

        this.graphics.add(new ClickySmileGraphic(this, imageContainer));
    }

    @Override
    public Graphic currentGraphic() {

        return super.currentGraphic();
    }

    @Override
    public String getName() {
        return "Clicky";
    }

}