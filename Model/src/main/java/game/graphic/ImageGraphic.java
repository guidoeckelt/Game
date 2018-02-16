package game.graphic;

import game.gameobject.GameObject;
import game.graphic.image.Image;

public class ImageGraphic extends Graphic {

    private Image image;

    public ImageGraphic(GameObject gameObject, Image image) {

        super(gameObject);
        this.image = image;
    }

    @Override
    public void draw(DrawParameters drawParameters) {
        double x = this.gameObject.getPosition().getX();
        double y = this.gameObject.getPosition().getY();

        drawParameters.getContext().drawImage(image, x, y);
    }
}
