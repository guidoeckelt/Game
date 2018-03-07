package de.charaktar.swing;

import de.charaktar.ge.Camera;
import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.graphic.image.MemoryImageConverter;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

import java.awt.*;
import java.awt.font.GlyphVector;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class SwingGraphicContext implements GraphicContext {

    private final BufferStrategy buffer;
    private Camera camera;
    private BufferedImage image;

    public SwingGraphicContext(BufferStrategy buffer, Camera camera) {

        this.buffer = buffer;
        this.camera = camera;
        this.image = new BufferedImage(
                (int) camera.getViewport().getWidth(), (int) camera.getViewport().getHeight()
                , BufferedImage.TYPE_INT_ARGB);
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
        Graphics2D g = this.getDrawGraphics();
        java.awt.Image imageAwt = new MemoryImageConverter(image).intoAwt();
        g.drawImage(imageAwt, intX, intY, intWidth, intHeight, null);
        this.dispose(g);
    }

    @Override
    public void drawText(String text, Vector position, Font font, String fillColor, double borderSize) {

        int intX = (int) position.getX();
        int intY = (int) position.getY();
        Graphics2D g = this.getDrawGraphics();
        GlyphVector gv = font.createGlyphVector(g.getFontRenderContext(), text);
        Shape textShape = gv.getOutline();
        g.translate(intX, intY + textShape.getBounds2D().getHeight());
        this.setStroke(g, (float) borderSize);
        this.setColor(g, fillColor);
        g.fill(textShape);
        this.setColor(g, "#000000");
        g.draw(textShape);
//        g.translate(-intX, -intY);
        this.dispose(g);
    }

    @Override
    public void drawRect(Vector position, Dimension size, String fillColor, String borderColor) {

        int intX = (int) position.getX();
        int intY = (int) position.getY();
        int intWidth = (int) size.getWidth();
        int intHeight = (int) size.getHeight();
        Graphics2D g = this.getDrawGraphics();
        if (fillColor != null) {
            this.setColor(g, fillColor);
            g.fillRect(intX, intY, intWidth, intHeight);
        }
        if (borderColor != null) {
            this.setColor(g, borderColor);
            g.drawRect(intX, intY, intWidth, intHeight);
        }
        this.dispose(g);
    }

    @Override
    public Image show() {

        Graphics g = this.buffer.getDrawGraphics();
        g.drawImage(this.image, 0, 0, null);
        buffer.show();
        this.dispose(g);
        return new Image(this.image);
    }

    private Graphics2D getDrawGraphics() {

        return this.image.createGraphics();
    }

    private void dispose(Graphics g) {

        g.dispose();
    }

    private void setColor(Graphics2D g, String color) {

        if (color.substring(1).length() <= 6) {
            g.setColor(Color.decode(color));
        } else {
            String alpha = color.substring(0, 3);
            float alphaF = (float) Integer.decode(alpha) / 255f;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaF));
            String colorWithoutAlpha = color.charAt(0) + color.substring(3);
            g.setColor(Color.decode(colorWithoutAlpha));
        }
    }

    private void setStroke(Graphics2D g, float size) {

        g.setStroke(new BasicStroke(size));
    }

}
