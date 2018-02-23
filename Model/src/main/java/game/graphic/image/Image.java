package game.graphic.image;

import game.graphic.image.png.PngImageReader;

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
    private Pixel[][] pixels;
    private File file;
    private BufferedImage awtImage;

    public Image(int width, int height) {

        this.width = width;
        this.height = height;
        this.pixels = new Pixel[height][width];
    }

    public Image(BufferedImage image) {

        this.readPixelsFromBufferedImage(image);
    }

    public Image(String filePath) throws IOException {

        this.getFromFile(filePath);
    }

    private void getFromFile(String filePath) throws IOException {

        this.file = new File(filePath);
//        byte[] allBytes = this.readBytesFromFile();
//        this.pixels = this.decodeBytes(allBytes);
        this.awtImage = ImageIO.read(this.file);
        this.readPixelsFromBufferedImage(this.awtImage);
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

    private void readPixelsFromBufferedImage(BufferedImage image) {

        this.width = image.getWidth();
        this.height = image.getHeight();
        this.pixels = new Pixel[this.height][this.width];
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                int pixelNumber = x + (y * this.width);
                int color = image.getRGB(x, y);
                this.pixels[y][x] = new Pixel(color);
//                    System.out.println(pixel.getRed()+";"+pixel.getGreen()+";"+pixel.getBlue()+";"+pixel.getAlpha());
            }
        }
    }

    public void capture(Image other, int startX, int startY) {

        this.capture(other, startX, startY, other.getWidth(), other.getHeight());
    }

    public void capture(Image other, int startX, int startY, int width, int height) {
        int endX = width;
        int endY = height;
        //TODO check for start x and y if less than 0
        if (startX + width > this.width - 1) {
            endX = this.width - startX;
        }
        if (startY + height > this.height - 1) {
            endY = this.height - startY;
        }
        for (int otherY = 0; otherY < endY; otherY++) {
            for (int otherX = 0; otherX < endX; otherX++) {
                int x = startX + otherX;
                int y = startY + otherY;
                this.pixels[y][x] = other.getPixel(otherX, otherY);
            }
        }
    }

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
        return this.pixels[y][x];
    }

    public void setPixel(int x, int y, int int_argb) {
        this.pixels[y][x] = new Pixel(int_argb);
    }

    public void setPixel(int x, int y, int red, int green, int blue) {
        this.pixels[y][x] = new Pixel(red, green, blue);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}
