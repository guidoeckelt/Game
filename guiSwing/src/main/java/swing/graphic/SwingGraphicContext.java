package swing.graphic;

import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.graphic.image.MemoryImageConverter;

import java.awt.*;

public class SwingGraphicContext implements GraphicContext {

    private final Image sceneImage;
    private Graphics g;
    private Graphics temp;

    public SwingGraphicContext(Graphics g) {
        this(g, null);
    }

    public SwingGraphicContext(Graphics g, Image currentImage) {
        this.g = g;
        this.sceneImage = currentImage;
    }

    @Override
    public void setSize(double width, double height) {
        this.temp = this.g.create();
    }

    @Override
    public void drawImage(Image image, double x, double y, double width, double height) {
        if (this.sceneImage != null) {
            this.sceneImage.capture(image, (int) x, (int) y);
            return;
        }
        java.awt.Image imageAwt = new MemoryImageConverter(image).intoAwt();
        this.g.drawImage(imageAwt, (int) x, (int) y, (int) width, (int) height, null);
    }

    @Override
    public void drawImage(Image image, double x, double y) {
        if (this.sceneImage != null) {
            this.sceneImage.capture(image, (int) x, (int) y);
            return;
        }
        java.awt.Image imageAwt = new MemoryImageConverter(image).intoAwt();
        this.g.drawImage(imageAwt, (int) x, (int) y, image.getWidth(), image.getHeight(), null);
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
