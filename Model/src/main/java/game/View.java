package game;

import game.gameobject.GameObject;
import game.graphic.DrawParameters;
import game.graphic.Graphic;
import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.input.Mouse;
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
        this.delay = 10;

        this.canvas = canvas;
        this.camera = new Camera(new Vector(0, 0), canvas.getViewport());
    }

    public void render(Game game) {
        this.game = game;
        this.renderLoop();
    }

    private void renderLoop() {

        GraphicContext context = this.canvas.newGraphicContext(camera);
        this.drawBackground(context);
        if (game.getCurrentScene() != null) {
            this.drawGameObjects(context, game.getCurrentScene().getGameObjects());
        }
        this.drawMouse(context, game.getMouse());
        this.canvas.draw();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                renderLoop();
                this.cancel();
            }
        };
        timer.scheduleAtFixedRate(task, this.delay, 666);
    }


    private void drawBackground(GraphicContext context) {

        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#000000", null);
    }

    private void drawGameObjects(GraphicContext context, List<GameObject> gameObjects) {

        for (GameObject gameObject : gameObjects) {
            if (!camera.isGameObjectVisible(gameObject)) {
                continue;
            }
            DrawParameters drawParameters = new DrawParameters(context);
            Graphic graphic = gameObject.currentGraphic();
            graphic.draw(drawParameters);
        }
    }

    private void drawMouse(GraphicContext context, Mouse mouse) {

        Vector position = mouse.getPosition();
        if (position.getX() < 0 || position.getY() < 0) {
            return;
        }
        Image image = this.game.getImageContainer().loadImage("Cursor", "cursor-2.png");
        context.drawImage(image, position);
    }

}
