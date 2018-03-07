package de.charaktar.ge;

import de.charaktar.ge.metric.Vector;

/**
 * Created by Guido on 05.05.2016.
 */
public class View {

    private Canvas canvas;
    private RenderLoop renderLoop;

    public View(Canvas canvas) {

        this.canvas = canvas;
    }

    public void render(Game game) {

        Camera camera = new Camera(new Vector(0, 0), this.canvas.getViewport());
        this.renderLoop = new DefaultGameRenderLoop(this.canvas, camera, game);
        this.renderLoop.start();
    }

}
