package game.Graphic;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageContainer {

    private List<Image> allLoadedImages = new ArrayList<>();

    public ImageContainer() {

    }

//    public Image getImage(){
//
//    }

    public void loadImage(String filePath) {
        Image image = this.loadImageFromPath(filePath);
        this.allLoadedImages.add(image);
    }

    public void loadImages(List<String> filePathList) {
        for (String filePath : filePathList) {
            Image image = this.loadImageFromPath(filePath);
            this.allLoadedImages.add(image);
        }

    }

    private Image loadImageFromPath(String filePath) {
        Image image = new Image("file://" + filePath);
        return image;
    }
}
