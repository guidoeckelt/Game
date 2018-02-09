package game.graphic.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Image {

    private int width;
    private int height;
    private File file;
    private BufferedImage image;
    private Pixel[][] pixels;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new Pixel[height][width];
    }

    public Image(String filePath) {

        this(filePath, -1, -1);
    }

    public Image(String filePath, int width, int height) {
        this.file = new File(filePath);
        this.width = width;
        this.height = height;
        this.readPixels();
    }

    public void capture(Image other, int startX, int startY) {
        int endX = other.getWidth();
        int endY = other.getHeight();
        if (startX + other.getWidth() > this.width - 1) {
            endX = this.width - startX;
        }
        if (startY + other.getHeight() > this.height - 1) {
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

    private void readPixels() {
        try {
            this.image = ImageIO.read(this.file);
            this.width = image.getWidth();
            this.height = image.getHeight();
            pixels = new Pixel[height][width];
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int pixelNumber = x + (y * width);
                    int color = image.getRGB(x, y);
                    Pixel pixel = new Pixel(color);
                    this.pixels[y][x] = pixel;
//                    System.out.println(pixel.getRed()+";"+pixel.getGreen()+";"+pixel.getBlue()+";"+pixel.getAlpha());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] readBytes() {
        try {
//            return IOUtils.readFully(new FileInputStream(this.file), );
            return Files.readAllBytes(this.file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
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
