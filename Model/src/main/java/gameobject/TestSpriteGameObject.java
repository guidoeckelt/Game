package gameobject;

import metric.Dimension;
import metric.Vector;

import java.util.ArrayList;
import java.util.List;

public class TestSpriteGameObject extends GameObject {

    public TestSpriteGameObject(Vector position, Dimension size) {
        super(position, size);
        List<String> paths = new ArrayList<>();
        paths.add("D:\\DevGame\\Sprites\\Undertale\\AnnoyingDog\\eat-1.png");
        paths.add("D:\\DevGame\\Sprites\\Undertale\\AnnoyingDog\\eat-2.png");
        paths.add("D:\\DevGame\\Sprites\\Undertale\\AnnoyingDog\\eat-3.png");
        paths.add("D:\\DevGame\\Sprites\\Undertale\\AnnoyingDog\\eat-4.png");
        paths.add("D:\\DevGame\\Sprites\\Undertale\\AnnoyingDog\\eat-5.png");
        paths.add("D:\\DevGame\\Sprites\\Undertale\\AnnoyingDog\\eat-6.png");
        paths.add("D:\\DevGame\\Sprites\\Undertale\\AnnoyingDog\\eat-7.png");
        paths.add("D:\\DevGame\\Sprites\\Undertale\\AnnoyingDog\\eat-8.png");
//        this.graphics = new SpriteGraphic(this, paths);
    }
}

