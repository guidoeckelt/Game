package swing.graphic;

import game.Camera;
import game.graphic.GraphicContext;
import game.graphic.image.Image;

public class SwingGraphicContext implements GraphicContext {

    private Camera camera;
    private Image canvasImage;

    public SwingGraphicContext(Camera camera, Image canvasImage) {
        this.camera = camera;
        this.canvasImage = canvasImage;
    }

    @Override
    public void drawImage(Image image, double x, double y, double width, double height) {
        this.canvasImage.capture(image, (int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public void drawImage(Image image, double x, double y) {
        this.canvasImage.capture(image, (int) x, (int) y);
    }

    @Override
    public void drawText(String name, double x, double y, String color) {

    }

    @Override
    public void drawRect(double startX, double startY, double width, double height, String fillColor, String borderColor) {
        int endX = (int) (startX + width);
        int endY = (int) (startY + height);
        if (fillColor != null) {
            for (int y = (int) startY; y < endY; y++) {
                for (int x = (int) startX; x < endX; x++) {
                    int int_argb = Integer.decode(fillColor);
                    this.canvasImage.setPixel(x, y, int_argb);
                }
            }
        }
        if (borderColor != null) {
            for (int cycles = 0; cycles < 2; cycles++) {
                for (int i = 0; i < width; i++) {
                    this.canvasImage.setPixel(i, 0, Integer.decode(borderColor));
                    this.canvasImage.setPixel(i, (int) height, Integer.decode(borderColor));
                    this.canvasImage.setPixel(0, i, Integer.decode(borderColor));
                    this.canvasImage.setPixel((int) width, i, Integer.decode(borderColor));
                }
            }
        }
    }
}
