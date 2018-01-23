package game.Graphic;

import java.util.Dictionary;
import java.util.Hashtable;

public class ImageContainer {

    private final String protocol = "file://";
    private String rootPath;
    private Dictionary<String, Image> imageDictionary;

    public ImageContainer() {
        this.rootPath = "D:\\DevGame\\Sprites\\";
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
        return new Image(rootPath + filePath, width, height);
    }

    private Image loadImageFromPath(String filePath) {
        return new Image(rootPath + filePath);
    }

}
