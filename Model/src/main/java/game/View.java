package game;

import game.graphic.DrawParameters;
import game.graphic.Graphic;
import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.input.Mouse;
import game.metric.Vector;

import java.awt.*;
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
    private Image lastGameImage;

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
        if (status.getMode().equals(GameMode.RUNNING)) {
            this.drawGame(context, status);
            this.drawMouse(context, game.getMouse());
            this.lastGameImage = context.show();
        } else if (status.getMode().equals(GameMode.PAUSE)) {
            this.drawGamePauseUi(context);
            this.drawMouse(context, game.getMouse());
            context.show();
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                renderLoop();
                this.cancel();
            }
        };
        timer.scheduleAtFixedRate(task, this.delay, 666);
    }

    private void drawGame(GraphicContext context, GameStatus status) {

        this.drawGameBackground(context);
        this.drawGameGraphics(context, status);
    }

    private void drawGameBackground(GraphicContext context) {

        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AAAAAA", null);
    }

    private void drawGameGraphics(GraphicContext context, GameStatus status) {

        DrawParameters drawParameters = new DrawParameters(context, status.getHoveredGameObject());
        for (Graphic graphic : status.getGraphics()) {
            graphic.draw(drawParameters);
        }
    }

    private void drawGamePauseUi(GraphicContext context) {

        if (this.lastGameImage != null) {
            context.drawImage(this.lastGameImage, new Vector(0, 0));
        }
        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#91000000", null);
        context.drawText("Pause", new Vector(700, 500), new Font("Arial", Font.BOLD, 100), "#FFFFFF", 5);
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
