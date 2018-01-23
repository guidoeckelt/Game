package game;

import game.Graphic.DrawParameters;
import game.Graphic.Graphic;
import game.Graphic.GraphicContext;
import game.gameobject.GameObject;
import game.metric.Vector;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Guido on 05.05.2016.
 */
public class View {

    private Timer timer;
    private int delay;

    private Game game;
    private Canvas canvas;
    private Camera camera;

    public View(Canvas canvas) {

        this.timer = new Timer(true);
        this.delay = 20;

        this.canvas = canvas;
        this.camera = new Camera(new Vector(0, 0), canvas.getViewport());
    }

    public void render(Game game) {
        this.game = game;
        this.renderLoop();
    }

    private void renderLoop() {
        this.canvas.clear();
        this.drawBackground();
        this.drawGameObjects(game.getCurrentScene().getGameObjects());
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                renderLoop();
                this.cancel();
            }
        };
        timer.scheduleAtFixedRate(task, this.delay, 20);
    }

    private void drawBackground() {
        GraphicContext context = this.canvas.newGraphicContext();
        context.drawRect(0, 0, this.canvas.getViewport().getWidth(), this.canvas.getViewport().getHeight(), "#AAAAAA", null);
    }

    private void drawGameObjects(List<GameObject> gameObjects) {
        for (GameObject gameObject : gameObjects) {
            DrawParameters drawParameters = new DrawParameters(this.canvas.newGraphicContext());
            Graphic graphic = gameObject.currentGraphic();
            graphic.draw(drawParameters);
        }
    }

//    public Canvas getScene() {
//        return this.scene;
//    }

}
