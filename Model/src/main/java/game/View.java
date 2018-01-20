package game;

import game.Graphic.Graphic;
import gameobject.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import util.DrawParameters;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Guido on 05.05.2016.
 */
public class View {

    private Timer timer;
    private int delay;
    private TimerTask renderLoopTask;
    private Game game;

    private double fieldSize;
    private Canvas scene;
    private GraphicsContext context;

    public View() {

        this.timer = new Timer();
        this.renderLoopTask = new TimerTask() {
            @Override
            public void run() {
                renderLoop();
            }
        };
        this.delay = 10;

        this.scene = new Canvas(1200, 900);
        this.context = this.scene.getGraphicsContext2D();
        fieldSize = 10;
    }

    public void render(Game game) {
        this.game = game;
        this.renderLoop();
        timer.scheduleAtFixedRate(this.renderLoopTask, 0, this.delay);
    }

    private void renderLoop() {
        this.clearCanvas();
        this.drawBackground();
        this.drawGameObjects(game.getGameObjects());
//        Platform.runLater(() -> {
//        });
    }

    private void clearCanvas() {
        this.context.clearRect(0, 0, this.scene.getWidth(), this.scene.getHeight());
    }

    private void drawBackground() {
        this.context.setStroke(Color.BLACK);
        this.context.setFill(Color.GRAY);
        this.context.fillRect(0, 0, this.scene.getWidth(), this.scene.getHeight());
    }

    private void drawGameObjects(List<GameObject> gameObjects) {
        DrawParameters drawParameters = new DrawParameters(context, fieldSize);
        for (GameObject gameObject : gameObjects) {
            Graphic graphic = gameObject.currentGraphic();
            graphic.draw(drawParameters);
        }
    }

    public double getWidth() {
        return this.scene.getWidth();
    }


    public double getHeight() {
        return this.scene.getHeight();
    }

    public Canvas getScene() {
        return this.scene;
    }

    public double getFieldSize() {
        return fieldSize;
    }

}
