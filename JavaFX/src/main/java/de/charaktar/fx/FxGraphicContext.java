package de.charaktar.fx;

import de.charaktar.ge.Camera;
import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.graphic.image.Pixel;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class FxGraphicContext implements GraphicContext {

    private Camera camera;
    private WritableImage image;
    private GraphicsContext context;

    public FxGraphicContext(GraphicsContext context, Camera camera) {
        this.context = context;
        this.camera = camera;
        this.image = new WritableImage((int) camera.getViewport().getWidth(), (int) camera.getViewport().getHeight());
    }

    @Override
    public void drawImage(Image image, Vector position) {

        this.drawImage(image, position, new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    public void drawImage(Image image, Vector position, Dimension size) {

        for (int pixelY = 0; pixelY < size.getHeight(); pixelY++) {
            for (int pixelX = 0; pixelX < size.getWidth(); pixelX++) {
                Pixel pixel = image.getPixel(pixelX, pixelY);
                String color = "#" + getHexCode(pixel.getRed()) + getHexCode(pixel.getGreen()) + getHexCode(pixel.getBlue());
//                System.out.println(color + " : "+ getHexCode(pixel.getRed()));
                this.image.getPixelWriter().setArgb(pixelX, pixelY, pixel.getInt_ARGB());
            }
        }
    }

    @Override
    public void drawText(String text, Vector position, java.awt.Font font, String fillColor, double borderSize) {

        this.context.setFill(Color.valueOf(fillColor));
        this.context.fillText(text, position.getX(), position.getY());
        this.context.setFill(Color.BLACK);
        this.context.strokeText(text, position.getX(), position.getY());
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

    @Override
    public Image show() {
        this.context.drawImage(this.image, 0, 0, camera.getViewport().getWidth(), camera.getViewport().getHeight());
        return new Image(this.image);
    }

    private String getHexCode(int value) {
        String string = Integer.toHexString(value);
        if (string.length() == 1) {
            return "0" + string;
        }
        return string;
    }

}
