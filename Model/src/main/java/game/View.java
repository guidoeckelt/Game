package game;

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
        this.delay = 1;

        this.canvas = canvas;
        this.camera = new Camera(new Vector(0, 0), canvas.getViewport());
    }

    public void render(Game game) {
        this.game = game;
        this.renderLoop();
    }

    private void renderLoop() {

        GameStatus status = this.game.getStatus();
        GraphicContext context = this.canvas.newGraphicContext(camera);
        this.drawBackground(context);
        if (game.getCurrentScene() != null) {
            this.drawGameGraphics(context, status.getGraphics());
        }
        this.drawMouse(context, game.getMouse());
        this.canvas.finalizeDrawing();

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

        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AAAAAA", null);
    }

    private void drawGameGraphics(GraphicContext context, List<Graphic> gameObjects) {

        for (Graphic graphic : gameObjects) {
//            if (!camera.isGameObjectVisible(graphic)) {
//                continue;
//            }
            DrawParameters drawParameters = new DrawParameters(context);
            graphic.draw(drawParameters);
        }
    }

    private void drawMouse(GraphicContext context, Mouse mouse) {

        Vector position = mouse.getPosition();
        if (position.getX() < 0 || position.getY() < 0) {
            return;
        }
        Image image = this.game.getImageContainer().loadImage("Cursor", "cursor.png");
        context.drawImage(image, position);
    }

}
