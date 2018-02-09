package game.graphic;

import game.gameobject.GameObject;
import game.graphic.image.Image;

import java.util.Date;
import java.util.List;

public class SpriteGraphic extends Graphic {


    private List<Image> imageList;
    private int currentImageIndex;
    private Date lastChange;
    private long spriteDelay;

    public SpriteGraphic(GameObject gameObject, List<Image> images, long spriteDelay) {

        super(gameObject);
        this.imageList = images;
        this.currentImageIndex = 0;
        this.lastChange = new Date();
        this.spriteDelay = spriteDelay;
    }

    @Override
    public void draw(DrawParameters drawParameters) {

        double width = this.gameObject.getSize().getWidth();
        double height = this.gameObject.getSize().getHeight();
        double x = this.gameObject.getPosition().getX();
        double y = this.gameObject.getPosition().getY();
        Image image = this.imageList.get(this.currentImageIndex);
//        drawParameters.getContext().setSize(width, height);
        drawParameters.getContext().drawImage(image, x, y, width, height);
        this.checkForNextImage();
    }

    private void checkForNextImage() {
        Date now = new Date();
        if (now.getTime() - this.lastChange.getTime() >= this.spriteDelay) {
            this.nextImage();
            this.lastChange = now;
        }
    }

    private void nextImage() {

        if (this.currentImageIndex == (this.imageList.size() - 1)) {
            this.currentImageIndex = 0;
        } else {
            this.currentImageIndex++;
        }

    }
}
