package fx.view;

import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.graphic.image.Pixel;
import game.metric.Dimension;
import game.metric.Vector;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class FxGraphicContext implements GraphicContext {

    private final Image image;
    private GraphicsContext context;

    public FxGraphicContext(GraphicsContext context) {

        this(context, null);
    }

    public FxGraphicContext(GraphicsContext context, Image currentImage) {

        this.context = context;
        this.image = currentImage;
    }

    @Override
    public void drawImage(Image image, Vector position) {

        this.drawImage(image, position, new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    public void drawImage(Image image, Vector position, Dimension size) {

//        this.context.drawImage(image, x, y, width, height);
        for (int pixelY = 0; pixelY < size.getHeight(); pixelY++) {
            for (int pixelX = 0; pixelX < size.getWidth(); pixelX++) {
                Pixel pixel = image.getPixel(pixelX, pixelY);
                String color = "#" + getHexCode(pixel.getRed()) + getHexCode(pixel.getGreen()) + getHexCode(pixel.getBlue());
//                System.out.println(color + " : "+ getHexCode(pixel.getRed()));
                this.context.setFill(Paint.valueOf(color));
                this.context.setGlobalAlpha(pixel.getAlpha());
                this.context.fillRect(position.getX() + pixelX, position.getY() + pixelY, 1, 1);
            }
        }
    }

    @Override
    public void drawText(String text, Vector position, String color) {

        this.context.setFill(Color.valueOf(color));
        this.context.fillText(text, position.getX(), position.getY());
    }

    private String getHexCode(int value) {
        String string = Integer.toHexString(value);
        if (string.length() == 1) {
            return "0" + string;
        }
        return string;
    }

    @Override
    public void drawRect(Vector position, Dimension size, String fillColor, String borderColor) {

        if (fillColor != null) {
            this.context.setFill(Paint.valueOf(fillColor));
            this.context.fillRect(position.getX(), position.getY(), size.getWidth(), size.getHeight());
        }
        if (borderColor != null) {
            this.context.setStroke(Paint.valueOf(borderColor));
            this.context.strokeRect(position.getX(), position.getY(), size.getWidth(), size.getHeight());
        }

    }

}
