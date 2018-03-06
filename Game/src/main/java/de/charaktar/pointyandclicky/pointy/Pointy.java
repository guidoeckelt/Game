package de.charaktar.pointyandclicky.pointy;

import de.charaktar.game.gameobject.GameObject;
import de.charaktar.game.graphic.Graphic;
import de.charaktar.game.graphic.image.ImageContainer;
import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;

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
