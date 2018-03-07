package de.charaktar.ge.graphic.image;

import de.charaktar.ge.graphic.image.png.PngImageReader;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Image {


    public static void main(String[] args) {
        String filePath = "D:\\DevGame\\PointyAndClicky\\media\\sprites\\pointy\\Front_Smile_32x32.png";
        try {
            Image image = new Image(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int width;
    private int height;
    private File file;
    private BufferedImage awtImage;
    private WritableImage fxImage;

    public Image(int width, int height) {

        this.setSize(width, height);
        this.awtImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
    }

    public Image(BufferedImage image) {

        this.awtImage = image;
        this.setSize(image.getWidth(), image.getHeight());
    }

    public Image(WritableImage image) {

        this.fxImage = image;
        this.setSize((int) image.getWidth(), (int) image.getHeight());
    }

    public Image(String filePath) throws IOException {

        this.file = new File(filePath);
        this.awtImage = ImageIO.read(this.file);
        this.setSize(this.awtImage.getWidth(), this.awtImage.getHeight());
//        byte[] allBytes = this.readBytesFromFile();
//        this.pixels = this.decodeBytes(allBytes);
    }

    private byte[] readBytesFromFile() throws IOException {

        return Files.readAllBytes(this.file.toPath());
    }

    private Pixel[][] decodeBytes(byte[] allBytes) {

        String fileName = this.file.getName();
        int dotIndex = fileName.lastIndexOf(".");
        String rawName = fileName.substring(0, dotIndex);
        String extension = fileName.substring(dotIndex + 1);
        System.out.println("rawName : " + rawName + "   | extension : " + extension);
        Pixel[][] pixels = null;
        if (extension.equalsIgnoreCase("png")) {
            PngImageReader reader = new PngImageReader(allBytes);
            pixels = reader.decodeToPixels();
        } else if (extension.equalsIgnoreCase("jpg")) {
            pixels = new Pixel[1][1];
        }
        return pixels;
    }

    private void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    //    public void capture(Image other, int x, int y) {
//        if (this.awtImage != null) {
//            Graphics2D g = this.awtImage.createGraphics();
//            g.drawImage(other.getAwt(), x, y, null);
//        }else {
//
//        }
//    }
//
//    public void capture(Image other, int startX, int startY, int width, int height) {
//
//        if (this.awtImage != null) {
//            Graphics2D g = this.awtImage.createGraphics();
//            g.drawImage(other.getAwt(), startX, startY, width, height, null);
//        }else {
//
//        }
//    }

    //====Public
    public static BufferedImage scale(BufferedImage imageToScale, int dWidth, int dHeight) {

        BufferedImage scaledImage = null;
        if (imageToScale != null) {
            scaledImage = new BufferedImage(dWidth, dHeight, imageToScale.getType());
            Graphics2D graphics2D = scaledImage.createGraphics();
            graphics2D.drawImage(imageToScale, 0, 0, dWidth, dHeight, null);
            graphics2D.dispose();
        }
        return scaledImage;
    }

    public Pixel getPixel(int x, int y) {
        if (this.awtImage != null) {
            return new Pixel(this.awtImage.getRGB(x, y));
        } else {
            return new Pixel(this.fxImage.getPixelReader().getArgb(x, y));
        }
    }

    public void setPixel(int x, int y, int int_argb) {
        if (this.awtImage != null) {
            this.awtImage.setRGB(x, y, int_argb);
        } else {
            this.fxImage.getPixelWriter().setArgb(x, y, int_argb);
        }
    }

    public void setPixel(int x, int y, int red, int green, int blue) {
        if (this.awtImage != null) {
            this.awtImage.setRGB(x, y, new Pixel(red, green, blue).getInt_ARGB());
        } else {
            this.fxImage.getPixelWriter().setArgb(x, y, new Pixel(red, green, blue).getInt_ARGB());
        }
    }

    public java.awt.Image getAwt() {

        if (this.awtImage != null) {
            return this.awtImage;
        } else {
            return new MemoryImageConverter(this.fxImage).intoAwt();
        }
    }

    public javafx.scene.image.Image getFx() {

        if (this.fxImage != null) {
            return this.fxImage;
        } else {
            return new MemoryImageConverter(this.awtImage).intoFx();
        }
    }

    //====Getter
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}
