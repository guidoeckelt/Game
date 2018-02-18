package game.graphic;


import game.graphic.image.Image;
import game.metric.Dimension;
import game.metric.Vector;

public interface GraphicContext {

    void drawImage(Image image, Vector position);

    void drawImage(Image image, Vector position, Dimension size);

    void drawRect(Vector position, Dimension size, String fillColor, String borderColor);

    void drawText(String name, Vector position, String color);

}
