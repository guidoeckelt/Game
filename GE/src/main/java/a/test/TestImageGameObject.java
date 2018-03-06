package a.test;

import de.charaktar.game.gameobject.GameObject;
import de.charaktar.game.graphic.Graphic;
import de.charaktar.game.graphic.ImageGraphic;
import de.charaktar.game.graphic.image.Image;
import de.charaktar.game.graphic.image.ImageContainer;
import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;

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
