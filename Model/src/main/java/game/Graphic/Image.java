package game.Graphic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Image {

    private int requestedWidth;
    private int requestedHeight;
    private File file;
    private BufferedImage image;
    private Pixel[][] pixels;

    public Image(String filePath) {

        this(filePath, -1, -1);
    }

    public Image(String filePath, int width, int height) {
        this.file = new File(filePath);
        this.requestedWidth = width;
        this.requestedHeight = height;
        this.readPixels();
    }

    private void readPixels() {
        try {
            this.image = ImageIO.read(this.file);
            pixels = new Pixel[image.getWidth()][image.getHeight()];
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int pixelNumber = x + (y * image.getWidth());
                    int color = image.getRGB(x, y);
                    Pixel pixel = new Pixel(color);
                    this.pixels[x][y] = pixel;
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
        return this.pixels[x][y];
    }

    public double getWidth() {
        return this.image.getWidth();
    }

    public double getHeight() {
        return this.image.getHeight();
    }

}
