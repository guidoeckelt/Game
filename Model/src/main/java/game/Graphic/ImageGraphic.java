package game.Graphic;

import gameobject.GameObject;
import javafx.scene.image.Image;
import util.DrawParameters;

public class ImageGraphic extends Graphic<GameObject> {

    private String filePath;
    private Image image;

    public ImageGraphic(GameObject gameObject, String filePath) {
        super(gameObject);
        this.filePath = filePath;
        this.image = new Image("file:" + filePath);
    }

    @Override
    public void draw(DrawParameters drawParameters) {
        drawParameters.getContext().drawImage(this.image
                , this.gameObject.getPosition().getX(), this.gameObject.getPosition().getY()
                , this.gameObject.getSize().getWidth(), this.gameObject.getSize().getHeight());
    }
}
