package game;

import game.metric.Vector;

/**
 * Created by Guido on 05.05.2016.
 */
public class View {

    private Game game;
    private Canvas canvas;
    private RenderLoop renderLoop;
    private Camera camera;

    public View(Canvas canvas) {

        this.canvas = canvas;
        this.camera = new Camera(new Vector(0, 0), canvas.getViewport());
        this.renderLoop = new RenderLoop(this.canvas, this.camera);
    }

    public void render(Game game) {

        this.game = game;
        this.renderLoop.start(game);
    }

}
