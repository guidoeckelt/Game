package game.gameobject;

import game.Graphic.Graphic;
import game.Graphic.Image;
import game.Graphic.ImageContainer;
import game.Graphic.ImageGraphic;
import game.metric.Dimension;
import game.metric.Vector;

public class TestImageGameObject extends GameObject {

    public TestImageGameObject(Vector position, Dimension size) {

        super(position, size);
    }

    @Override
    public void createGraphics(ImageContainer imageContainer) {

        String key = "Test-1";
        String path = "herz3.png";
        Image image = imageContainer.loadImage(key, path);
        this.graphics.add(new ImageGraphic(this, image));
    }

    @Override
    public Graphic currentGraphic() {

        return super.currentGraphic();
    }
}
