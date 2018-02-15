package a.pointyandclicky.clicky;

import game.gameobject.GameObject;
import game.graphic.Graphic;
import game.graphic.image.ImageContainer;
import game.metric.Dimension;
import game.metric.Vector;

public class Clicky extends GameObject {

    public Clicky(Vector position) {
        super(position, new Dimension(200, 200));

    }

    @Override
    public void createGraphics(ImageContainer imageContainer) {

        this.graphics.add(new ClickySmileGraphic(this, imageContainer));
    }

    @Override
    public Graphic currentGraphic() {

        return super.currentGraphic();
    }

}