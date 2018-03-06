package a.test;

import de.charaktar.game.gameobject.GameObject;
import de.charaktar.game.graphic.SpriteGraphic;
import de.charaktar.game.graphic.image.Image;
import de.charaktar.game.graphic.image.ImageContainer;
import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;

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
            images.add(imageContainer.loadImage(key, path));
        }
        this.graphics.add(new SpriteGraphic(this, images, 200));

    }

}

