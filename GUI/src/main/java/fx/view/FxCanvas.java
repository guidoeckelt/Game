package fx.view;

import game.Camera;
import game.Canvas;
import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.metric.Dimension;
import javafx.scene.canvas.GraphicsContext;

public class FxCanvas implements Canvas {

    private javafx.scene.canvas.Canvas canvas;
    private GraphicsContext context;

    public FxCanvas(javafx.scene.canvas.Canvas canvas) {
        this.canvas = canvas;
        this.context = this.canvas.getGraphicsContext2D();
    }

    @Override
    public Dimension getViewport() {
        return new Dimension(this.canvas.getWidth(), this.canvas.getHeight());
    }

    @Override
    public GraphicContext newGraphicContext(Camera camera, Image currentImage) {
        return new FxGraphicContext(this.context, currentImage);
    }

    @Override
    public void clear() {
        this.context.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
    }

    @Override
    public GraphicContext newGraphicContext() {
        return new FxGraphicContext(this.context);
    }


}
