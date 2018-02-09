package game.gameobject;

import game.graphic.Graphic;
import game.graphic.ImageGraphic;
import game.graphic.image.Image;
import game.graphic.image.ImageContainer;
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
