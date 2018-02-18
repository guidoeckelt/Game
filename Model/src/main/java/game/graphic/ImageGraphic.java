package game.graphic;

import game.gameobject.GameObject;
import game.graphic.image.Image;

public class ImageGraphic implements Graphic {

    private Image image;
    private GameObject gameObject;

    public ImageGraphic(GameObject gameObject, Image image) {

        this.gameObject = gameObject;
        this.image = image;
    }

    @Override
    public void draw(DrawParameters drawParameters) {
        double x = this.gameObject.getPosition().getX();
        double y = this.gameObject.getPosition().getY();

        drawParameters.getContext().drawImage(image, this.gameObject.getPosition());
    }
}
