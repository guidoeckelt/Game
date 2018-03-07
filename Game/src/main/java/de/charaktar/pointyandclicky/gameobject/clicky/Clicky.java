package de.charaktar.pointyandclicky.gameobject.clicky;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.image.ImageContainer;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

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