package game.graphic;


import game.graphic.image.Image;

public interface GraphicContext {

    void setSize(double width, double height);

    void drawImage(Image image, double x, double y, double width, double height);

    void drawImage(Image image, double x, double y);

    void drawRect(double x, double y, double width, double height, String fillColor, String borderColor);
}
