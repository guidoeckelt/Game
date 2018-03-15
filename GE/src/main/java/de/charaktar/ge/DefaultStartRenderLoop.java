package de.charaktar.ge;

import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.graphic.ui.Button;
import de.charaktar.ge.graphic.ui.UIParent;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;


public class DefaultStartRenderLoop implements RenderLoop {

    private Canvas canvas;
    private Camera camera;
    private UIParent ui;

    public DefaultStartRenderLoop(Canvas canvas) {

        this.canvas = canvas;
        this.camera = new Camera(new Vector(0, 0), this.canvas.getViewport());
        this.ui = new UIParent();
        Button b = new Button("Continue", this::continueGame, new Dimension(700, 100));
        ui.add(b);
        ui.add(new Button("New", new Dimension(700, 100)));
        ui.add(new Button("Load", new Dimension(700, 100)));
        ui.add(new Button("Exit", new Dimension(700, 100)));
    }

    private void continueGame() {

        System.out.println("continueGame");
    }

    @Override
    public Image tick() {

        DrawingContext context = this.canvas.newDrawingContext(this.camera);
        context.fillRect(new Vector(0, 0), this.canvas.getViewport(), "#888888");
        this.ui.draw(context);
        return context.end();
    }

}
