package game.graphic;


import game.graphic.image.Image;
import game.metric.Dimension;
import game.metric.Vector;

import java.awt.*;

public interface GraphicContext {

    void drawImage(Image image, Vector position);

    void drawImage(Image image, Vector position, Dimension size);

    void drawText(String text, Vector position, Font font, String fillColor, double borderSize);

    void drawRect(Vector position, Dimension size, String fillColor, String borderColor);

}
