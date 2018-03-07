package de.charaktar.ge.graphic.image;

import javafx.scene.image.WritableImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;

public class MemoryImageConverter {


    private BufferedImage awtImage;
    private WritableImage fxImage;
    private Image image;

    public MemoryImageConverter(Image image) {

        this.image = image;
    }

    public MemoryImageConverter(BufferedImage image) {

        this.awtImage = image;
    }

    public MemoryImageConverter(WritableImage fxImage) {

        this.fxImage = fxImage;
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
                pixels[index] = pixel.getInt_ARGB();
                index++;
            }
        }
        return defaultToolkit.createImage(new MemoryImageSource(width, height, pixels, 0, width));
    }

    public javafx.scene.image.Image intoFx() {

        if (this.fxImage != null) {
            return this.fxImage;
        }
        this.fxImage = new WritableImage(this.awtImage.getWidth(), this.awtImage.getHeight());
        for (int y = 0; y < this.fxImage.getHeight(); y++) {
            for (int x = 0; x < this.fxImage.getWidth(); x++) {
                this.fxImage.getPixelWriter().setArgb(x, y, this.awtImage.getRGB(x, y));
            }
        }
        return this.fxImage;
    }
}
