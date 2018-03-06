package de.charaktar.game.graphic;


import de.charaktar.game.graphic.image.Image;
import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;

import java.awt.*;

public interface GraphicContext {

    void drawImage(de.charaktar.game.graphic.image.Image image, Vector position);

    void drawImage(de.charaktar.game.graphic.image.Image image, Vector position, Dimension size);

    void drawText(String text, Vector position, Font font, String fillColor, double borderSize);

    void drawRect(Vector position, Dimension size, String fillColor, String borderColor);

    Image show();

}
