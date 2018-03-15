package de.charaktar.ge.swing;

import de.charaktar.ge.Camera;
import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

import java.awt.*;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;

public class SwingGraphicContext implements GraphicContext {

    private final String defaultTextFill = "#FFFFFF";
    private final String defaultTextStroke = "#000000";
    private final String defaultFill = "#000000";
    private final String defaultStroke = "#FFFFFF";

    private de.charaktar.ge.Canvas canvas;
    private Camera camera;
    private BufferedImage image;

    public SwingGraphicContext(de.charaktar.ge.Canvas canvas, Camera camera) {

        this.canvas = canvas;
        this.camera = camera;
        this.image = new BufferedImage(
                (int) canvas.getViewport().getWidth(), (int) canvas.getViewport().getHeight()
                , BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void fillRect(Vector position, Dimension size, String color) {

        int intX = (int) position.getX();
        int intY = (int) position.getY();
        int intWidth = (int) size.getWidth();
        int intHeight = (int) size.getHeight();
        Graphics2D g = this.getDrawGraphics();
        if (color == null) {
            color = this.defaultFill;
        }
        this.setColor(g, color);
        g.fillRect(intX, intY, intWidth, intHeight);
        g.dispose();
    }

    @Override
    public void strokeRect(Vector position, Dimension size, String color, double strokeWidth) {

        int intX = (int) position.getX();
        int intY = (int) position.getY();
        int intWidth = (int) size.getWidth();
        int intHeight = (int) size.getHeight();
        Graphics2D g = this.getDrawGraphics();
        if (strokeWidth < 1) {
            strokeWidth = 1;
        }
        this.setStroke(g, (float) strokeWidth);
        if (color == null) {
            color = this.defaultStroke;
        }
        this.setColor(g, color);
        g.drawRect(intX, intY, intWidth, intHeight);
        g.dispose();
    }

    @Override
    public void fillText(String text, Vector start, Font font, String color) {

        Graphics2D g = this.getDrawGraphics();
        GlyphVector glyphVector = font.createGlyphVector(g.getFontRenderContext(), text);
        Shape shape = glyphVector.getOutline();
        g.translate(start.getX(), start.getY() + shape.getBounds2D().getHeight());
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        if (color == null) {
            color = this.defaultTextFill;
        }
        this.setColor(g, color);
        g.fill(shape);
        g.dispose();
    }


    @Override
    public void strokeText(String text, Vector start, Font font, String color, double strokeWidth) {

        Graphics2D g = this.getDrawGraphics();
        GlyphVector glyphVector = font.createGlyphVector(g.getFontRenderContext(), text);
        Shape shape = glyphVector.getOutline();
        g.translate(start.getX(), start.getY() + shape.getBounds2D().getHeight());
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        if (strokeWidth < 1) {
            strokeWidth = 1;
        }
        this.setStroke(g, (float) strokeWidth);
        if (color == null) {
            color = this.defaultTextStroke;
        }
        this.setColor(g, color);
        g.draw(shape);
        g.dispose();
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
        g.drawImage(image.getAwt(), intX, intY, intWidth, intHeight, null);
        g.dispose();
    }

    public Image get() {

        return new Image(this.image);
    }

    @Override
    public Dimension getViewport() {
        return this.canvas.getViewport();
    }

    private Graphics2D getDrawGraphics() {

        return this.image.createGraphics();
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
