package game.graphic;

import game.gameobject.GameObject;
import game.graphic.image.Image;

import java.util.Date;
import java.util.List;

public class SpriteGraphic implements Graphic {

    private GameObject gameObject;
    private List<Image> imageList;
    private int currentImageIndex;
    private Date lastChange;
    private long spriteDelay;

    public SpriteGraphic(GameObject gameObject, List<Image> images, long spriteDelay) {

        this.gameObject = gameObject;
        this.imageList = images;
        this.spriteDelay = spriteDelay;

        this.currentImageIndex = 0;
        this.lastChange = new Date();
    }

    @Override
    public void draw(DrawParameters drawParameters) {

        Image image = this.imageList.get(this.currentImageIndex);
        drawParameters.getContext().drawImage(image, this.gameObject.getPosition(), this.gameObject.getSize());
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
