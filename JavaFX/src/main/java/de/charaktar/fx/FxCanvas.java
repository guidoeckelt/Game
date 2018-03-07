package de.charaktar.fx;


import de.charaktar.ge.Camera;
import de.charaktar.ge.Canvas;
import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.metric.Dimension;
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
    public GraphicContext newGraphicContext(Camera camera) {

        return new FxGraphicContext(this.context, camera);
    }

}
