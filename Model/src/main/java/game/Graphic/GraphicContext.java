package game.Graphic;


public interface GraphicContext {

    void setSize(double width, double height);

    void drawImage(Image image, double x, double y, double width, double height);

    void drawRect(double x, double y, double width, double height, String fillColor, String borderColor);
}
