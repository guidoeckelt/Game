package de.charaktar.ge;

import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;
import de.charaktar.ge.swing.SwingGraphicContext;

import java.awt.*;

public class DrawingContext implements GraphicContext {

    private SwingGraphicContext context;

    public DrawingContext(SwingGraphicContext context) {

        this.context = context;

    }

    @Override
    public void fillRect(Vector position, Dimension size, String color) {

        this.context.fillRect(position, size, color);
    }

    @Override
    public void strokeRect(Vector position, Dimension size, String color, double strokeWidth) {

        this.context.strokeRect(position, size, color, strokeWidth);
    }

    @Override
    public void fillText(String text, Vector start, Font font, String color) {

        this.context.fillText(text, start, font, color);
    }

    @Override
    public void strokeText(String text, Vector start, Font font, String color, double strokeWidth) {

        this.context.strokeText(text, start, font, color, strokeWidth);
    }

    @Override
    public void drawImage(Image image, Vector position) {

        this.context.drawImage(image, position);
    }

    @Override
    public void drawImage(Image image, Vector position, Dimension size) {

        this.context.drawImage(image, position, size);
    }

    @Override
    public Dimension getViewport() {
        return this.context.getViewport();
    }

    public Image end() {

        return this.context.get();
    }

}
