package de.charaktar.ge.graphic;


import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

import java.awt.*;

public interface GraphicContext {

    void drawImage(de.charaktar.ge.graphic.image.Image image, Vector position);

    void drawImage(de.charaktar.ge.graphic.image.Image image, Vector position, Dimension size);

    void drawText(String text, Vector position, Font font, String fillColor, double borderSize);

    void drawRect(Vector position, Dimension size, String fillColor, String borderColor);

    Image show();

}
