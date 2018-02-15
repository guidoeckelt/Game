package a.pointyandclicky.pointy;

import game.gameobject.GameObject;
import game.graphic.Graphic;
import game.graphic.image.ImageContainer;
import game.metric.Dimension;
import game.metric.Vector;

public class Pointy extends GameObject {

    public Pointy(Vector position) {
        super(position, new Dimension(200, 200));

    }

    @Override
    public void createGraphics(ImageContainer imageContainer) {

        this.graphics.add(new PointySmileGraphic(this, imageContainer));
    }

    @Override
    public Graphic currentGraphic() {

        return super.currentGraphic();
    }

}
