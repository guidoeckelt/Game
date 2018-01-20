package game.Graphic;

import gameobject.GameObject;
import javafx.scene.image.Image;
import util.DrawParameters;

import java.util.ArrayList;
import java.util.List;

public class SpriteGraphic extends Graphic<GameObject> {


    private List<String> filePathList;
    private List<Image> imageList = new ArrayList<>();
    private int currentImageIndex;

    public SpriteGraphic(GameObject gameObject, List<String> filePathList) {
        super(gameObject);
        this.filePathList = filePathList;
        this.currentImageIndex = 0;
        this.loadAllImages();
    }

    @Override
    public void draw(DrawParameters drawParameters) {
        Image image = this.imageList.get(this.currentImageIndex);
        drawParameters.getContext().drawImage(image
                , this.gameObject.getPosition().getX(), this.gameObject.getPosition().getY()
                , this.gameObject.getSize().getWidth(), this.gameObject.getSize().getHeight());
        this.nextImage();
    }

    private void loadAllImages() {
        for (int i = 0; i < this.filePathList.size(); i++) {
            String filePath = this.filePathList.get(i);
            Image image = new Image("file:" + filePath);
            this.imageList.add(image);
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
