package de.charaktar.pointyandclicky.gameobject.pointy;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.image.ImageContainer;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

public class Pointy extends GameObject {

    public Pointy(Vector position) {
        super(position, new Dimension(200, 200));
//        this.movementPattern = new SquareMovePattern(this);

    }

    @Override
    public void createGraphics(ImageContainer imageContainer) {

        this.graphics.add(new PointySmileGraphic(this, imageContainer));
        this.graphics.add(new PointyRotationGraphic(this, imageContainer));
    }

    @Override
    public Graphic currentGraphic() {

        return this.graphics.get(1);
    }

    @Override
    public String getName() {
        return "Pointy";
    }

}
