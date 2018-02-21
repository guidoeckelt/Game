package swing.graphic;

import game.Camera;
import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.graphic.image.MemoryImageConverter;
import game.metric.Dimension;
import game.metric.Vector;

import java.awt.*;
import java.awt.font.GlyphVector;
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
        Graphics2D g = (Graphics2D) this.buffer.getDrawGraphics();
        java.awt.Image imageAwt = new MemoryImageConverter(image).intoAwt();
        g.drawImage(imageAwt, intX, intY, intWidth, intHeight, null);
    }

    @Override
    public void drawText(String text, Vector position, Font font, String fillColor, double borderSize) {

        int intX = (int) position.getX();
        int intY = (int) position.getY();
        Graphics2D g = ((Graphics2D) this.buffer.getDrawGraphics());
        GlyphVector gv = font.createGlyphVector(g.getFontRenderContext(), text);
        Shape textShape = gv.getOutline();
        g.translate(intX, intY + textShape.getBounds2D().getHeight());
        this.setStroke(g, (float) borderSize);
        this.setColor(g, fillColor);
        g.fill(textShape);
        this.setColor(g, "#000000");
        g.draw(textShape);
//        g.translate(-intX, -intY);

    }


    @Override
    public void drawRect(Vector position, Dimension size, String fillColor, String borderColor) {

        int intX = (int) position.getX();
        int intY = (int) position.getY();
        int intWidth = (int) size.getWidth();
        int intHeight = (int) size.getHeight();
        Graphics2D g = (Graphics2D) this.buffer.getDrawGraphics();
        if (fillColor != null) {
            this.setColor(g, fillColor);
            g.fillRect(intX, intY, intWidth, intHeight);
        }
        if (borderColor != null) {
            this.setColor(g, borderColor);
            g.drawRect(intX, intY, intWidth, intHeight);
        }
    }

    private void setColor(Graphics2D g, String color) {

        g.setColor(Color.decode(color));
    }

    private void setStroke(Graphics2D g, float size) {

        g.setStroke(new BasicStroke(size));
    }

}
