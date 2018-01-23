package gui;

import game.Graphic.GraphicContext;
import game.Graphic.Image;
import game.Graphic.Pixel;

import java.awt.*;

public class SwingGraphicContext implements GraphicContext {

    private Graphics g;
    private Graphics temp;

    public SwingGraphicContext(Graphics g) {
        this.g = g;
    }

    @Override
    public void setSize(double width, double height) {
        this.temp = this.g.create();
    }

    @Override
    public void drawImage(Image image, double x, double y, double width, double height) {
        for (int pixelY = 0; pixelY < image.getHeight(); pixelY++) {
            for (int pixelX = 0; pixelX < image.getWidth(); pixelX++) {
                Pixel pixel = image.getPixel(pixelX, pixelY);
                String color = "#" + Integer.toHexString(pixel.getRed()) + Integer.toHexString(pixel.getGreen()) + Integer.toHexString(pixel.getBlue());
                this.g.setColor(Color.decode(color));
                this.g.fillRect((int) x + pixelX, (int) y + pixelY, 1, 1);
            }
        }
//        this.g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
    }

    @Override
    public void drawRect(double x, double y, double width, double height, String fillColor, String borderColor) {
        if (fillColor != null) {
            this.g.setColor(Color.decode(fillColor));
            this.g.fillRect((int) x, (int) y, (int) width, (int) height);
        }
        if (borderColor != null) {
            this.g.setColor(Color.decode(borderColor));
            this.g.drawRect((int) x, (int) y, (int) width, (int) height);
        }
    }
}
