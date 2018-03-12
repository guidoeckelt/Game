package de.charaktar.ge.graphic.image;

import javafx.scene.image.WritableImage;

import java.awt.image.BufferedImage;

public class MemoryImageConverter {

    private BufferedImage awtImage;
    private WritableImage fxImage;

    public MemoryImageConverter(BufferedImage image) {

        this.awtImage = image;
    }

    public MemoryImageConverter(WritableImage fxImage) {

        this.fxImage = fxImage;
    }

    public java.awt.Image intoAwt() {

        if (this.awtImage != null) {
            return this.awtImage;
        }
        this.awtImage = new BufferedImage((int) this.fxImage.getWidth(), (int) this.fxImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < this.awtImage.getHeight(); y++) {
            for (int x = 0; x < this.awtImage.getWidth(); x++) {
                this.awtImage.setRGB(x, y, this.fxImage.getPixelReader().getArgb(x, y));
            }
        }
        return this.awtImage;
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
