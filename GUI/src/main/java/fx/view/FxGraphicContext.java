package fx.view;

import game.Graphic.GraphicContext;
import game.Graphic.Pixel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class FxGraphicContext implements GraphicContext {

    private GraphicsContext context;

    public FxGraphicContext(GraphicsContext context) {

        this.context = context;
    }

    @Override
    public void setSize(double width, double height) {

    }

    @Override
    public void drawImage(game.Graphic.Image image, double x, double y, double width, double height) {
        for (int pixelY = 0; pixelY < image.getHeight(); pixelY++) {
            for (int pixelX = 0; pixelX < image.getWidth(); pixelX++) {
                Pixel pixel = image.getPixel(pixelX, pixelY);
                String color = "#" + getHexCode(pixel.getRed()) + getHexCode(pixel.getGreen()) + getHexCode(pixel.getBlue());
//                System.out.println(color);
                this.context.setFill(Paint.valueOf(color));
                this.context.setGlobalAlpha(pixel.getAlpha());
                this.context.fillRect((int) x + pixelX, (int) y + pixelY, 1, 1);
            }
        }
//        this.context.drawImage(image, x, y, width, height);
    }

    private String getHexCode(int value) {
        if (value == 0) {
            return "00";
        }
        return Integer.toHexString(value);
    }

    @Override
    public void drawRect(double x, double y, double width, double height, String fillColor, String borderColor) {
        if (fillColor != null) {
            this.context.setFill(Paint.valueOf(fillColor));
            this.context.fillRect(x, y, width, height);
        }
        if (borderColor != null) {
            this.context.setStroke(Paint.valueOf(borderColor));
            this.context.strokeRect(x, y, width, height);
        }

    }

}
