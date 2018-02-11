package game.graphic.image;

import java.awt.*;
import java.awt.image.MemoryImageSource;

public class MemoryImageConverter {

    private Image image;

    public MemoryImageConverter(Image image) {
        this.image = image;
    }

    public java.awt.Image intoAwt() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        int pixels[] = new int[width * height];
        int index = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel pixel = image.getPixel(x, y);
                pixels[index] = pixel.getInt_argb();
                index++;
            }
        }
        return defaultToolkit.createImage(new MemoryImageSource(width, height, pixels, 0, width));
    }

    public javafx.scene.image.Image intoFx() {
//        return new javafx.scene.image.Image();
        return null;
    }
}
