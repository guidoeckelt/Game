package game.gameobject;

import game.Graphic.Image;
import game.Graphic.ImageContainer;
import game.Graphic.SpriteGraphic;
import game.metric.Dimension;
import game.metric.Vector;

import java.util.ArrayList;
import java.util.List;

public class TestSpriteGameObject extends GameObject {

    public TestSpriteGameObject(Vector position, Dimension size) {

        super(position, size);
    }

    @Override
    public void createGraphics(ImageContainer imageContainer) {

        List<Image> images = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            String key = "Dog-Eating-" + i;
            String path = "Undertale\\AnnoyingDog\\eat-" + i + ".png";
            images.add(imageContainer.loadImage(key, path, ((int) this.size.getWidth()), ((int) this.size.getHeight())));
        }
        this.graphics.add(new SpriteGraphic(this, images, 200));

    }

}

