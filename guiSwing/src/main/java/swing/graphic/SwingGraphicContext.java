package swing.graphic;

import game.Camera;
import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.graphic.image.MemoryImageConverter;
import game.metric.Dimension;
import game.metric.Vector;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class SwingGraphicContext implements GraphicContext {

    private final BufferStrategy buffer;
    private Camera camera;

    public SwingGraphicContext(BufferStrategy buffer, Camera camera) {
        this.buffer = buffer;
        this.camera = camera;
    }

    @Override
    public void drawImage(Image image, Vector position) {

        this.drawImage(image, position, new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    public void drawImage(Image image, Vector position, Dimension size) {

        int intX = (int) position.getX();
        int intY = (int) position.getY();
        int intWidth = (int) size.getWidth();
        int intHeight = (int) size.getHeight();
        Graphics g = this.buffer.getDrawGraphics();
        java.awt.Image imageAwt = new MemoryImageConverter(image).intoAwt();
        g.drawImage(imageAwt, intX, intY, intWidth, intHeight, null);
    }

    @Override
    public void drawText(String name, Vector position, String color) {


    }

    @Override
    public void drawRect(Vector position, Dimension size, String fillColor, String borderColor) {

        int intX = (int) position.getX();
        int intY = (int) position.getY();
        int intWidth = (int) size.getWidth();
        int intHeight = (int) size.getHeight();
        Graphics g = this.buffer.getDrawGraphics();
        if (fillColor != null) {
            Color color = Color.decode(fillColor);
            g.setColor(color);
            g.fillRect(intX, intY, intWidth, intHeight);
        }
        if (borderColor != null) {
            Color color = Color.decode(borderColor);
            g.setColor(color);
            g.drawRect(intX, intY, intWidth, intHeight);
        }
    }

}
