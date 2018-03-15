package de.charaktar.ge.graphic;


import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

import java.awt.*;

public interface GraphicContext {

    void fillRect(Vector position, Dimension size, String color);

    void strokeRect(Vector position, Dimension size, String color, double strokeWidth);

    void fillText(String text, Vector start, Font font, String color);

    void strokeText(String text, Vector start, Font font, String color, double strokeWidth);

    void drawImage(de.charaktar.ge.graphic.image.Image image, Vector position);

    void drawImage(de.charaktar.ge.graphic.image.Image image, Vector position, Dimension size);

    Dimension getViewport();

}
