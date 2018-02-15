package game.graphic.image;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class ImageContainer {

    private final String protocol = "file://";
    private String rootPath;
    private String rootPath2;
    private Dictionary<String, Image> imageDictionary;

    public ImageContainer() {
        this.rootPath = "D:\\DevGame\\PointyAndClicky\\media\\sprites\\";
        this.rootPath2 = "D:\\DevGame\\Sprites\\";
        this.imageDictionary = new Hashtable<>();

    }

    public Image loadImage(String key, String filePath, int width, int height) {
        Image image;
        if (this.imageDictionary.get(key) != null) {
            image = this.imageDictionary.get(key);
        } else {
            image = this.loadImageFromPath(filePath, width, height);
            this.imageDictionary.put(key, image);
        }
        return image;
    }

    public Image loadImage(String key, String filePath) {
        Image image;
        if (this.imageDictionary.get(key) != null) {
            image = this.imageDictionary.get(key);
        } else {
            image = this.loadImageFromPath(filePath);
            this.imageDictionary.put(key, image);
        }
        return image;
    }

    public Dictionary<String, Image> loadImages(Dictionary<String, String> filePathDict) {
        Dictionary<String, Image> newLoadedImages = new Hashtable<>();
        while (filePathDict.keys().hasMoreElements()) {
            String key = filePathDict.keys().nextElement();
            String filePath = filePathDict.get(key);
            Image image = this.loadImage(key, filePath);
            newLoadedImages.put(key, image);
        }
        return newLoadedImages;
    }

    private Image loadImageFromPath(String filePath, int width, int height) {
        try {
            return new Image(this.rootPath + filePath, width, height);
        } catch (IOException ioe) {
            try {
                return new Image(this.rootPath2 + filePath, width, height);
            } catch (IOException ioe2) {
                ioe2.printStackTrace();
                return new Image(1, 1);
            }
        }
    }

    private Image loadImageFromPath(String filePath) {
        try {
            return new Image(this.rootPath + filePath);
        } catch (IOException ioe) {
            try {
                return new Image(this.rootPath2 + filePath);
            } catch (IOException ioe2) {
                ioe2.printStackTrace();
                return new Image(1, 1);
            }
        }
    }

}
