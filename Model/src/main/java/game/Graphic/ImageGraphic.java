package game.Graphic;

import game.gameobject.GameObject;

public class ImageGraphic extends Graphic {

    private Image image;

    public ImageGraphic(GameObject gameObject, Image image) {

        super(gameObject);
        this.image = image;
    }

    @Override
    public void draw(DrawParameters drawParameters) {
        double width = this.gameObject.getSize().getWidth();
        double height = this.gameObject.getSize().getHeight();
        double x = this.gameObject.getPosition().getX();
        double y = this.gameObject.getPosition().getY();

//        drawParameters.getContext().setSize(width, height);
        drawParameters.getContext().drawImage(image, x, y, width, height);
    }
}
