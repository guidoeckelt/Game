package a.test;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.ImageGraphic;
import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.graphic.image.ImageContainer;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

public class TestImageGameObject extends GameObject {

    public TestImageGameObject(Vector position, Dimension size) {

        super(position, size);
    }

    @Override
    public void createGraphics(ImageContainer imageContainer) {

        String key = "Test-1";
        String path = "pointy\\Smile_Front_32x32.png";
        Image image = imageContainer.loadImage(key, path);
        this.graphics.add(new ImageGraphic(this, image));
    }

    @Override
    public Graphic currentGraphic() {

        return super.currentGraphic();
    }
}
