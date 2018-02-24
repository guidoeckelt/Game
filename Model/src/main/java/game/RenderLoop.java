package game;

import game.graphic.DrawParameters;
import game.graphic.Graphic;
import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.metric.Vector;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class RenderLoop {

    private Timer timer;
    private TimerTask task;
    private long delay;
    private boolean isRunning;
    private Canvas canvas;
    private Camera currentCamera;
    private Game activeGame;
    private Image lastGameImage;

    public RenderLoop(Canvas canvas, Camera camera) {

        this(canvas, camera, 10);
    }

    public RenderLoop(Canvas canvas, Camera camera, long delay) {

        this.canvas = canvas;
        this.currentCamera = camera;
        this.delay = delay;
        this.isRunning = false;
    }

    public void start(Game game) {

        this.activeGame = game;
        this.createTask();
        this.startTimer();
    }

    public void pause() {

        this.isRunning = false;
        this.timer.cancel();
    }

    public void unpause() {

        this.createTask();
        this.startTimer();
    }

    private void loop() {

        if (this.activeGame != null) {
            this.drawGame(this.activeGame.currentStatus());
        } else {
            this.drawMenu();
        }
    }

    private void drawMenu() {

    }

    private void drawGame(GameStatus gameStatus) {

        GraphicContext context = this.canvas.newGraphicContext(this.currentCamera);
        if (gameStatus.getType().equals(GameStatusType.LOADING)) {
            this.drawLoadingUi(context);
        } else if (gameStatus.getType().equals(GameStatusType.RUNNING)) {
            this.drawGameBackground(context);
            this.drawGameGraphics(context, gameStatus);
            this.lastGameImage = context.show();
        } else if (gameStatus.getType().equals(GameStatusType.PAUSE)) {
            this.drawGamePauseUi(context);
            context.show();
        }
    }

    private void drawLoadingUi(GraphicContext context) {

        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AAAAAA", null);
        context.drawText("Loading", new Vector(700, 500), new Font("Arial", Font.BOLD, 100), "#FFFFFF", 5);
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
        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AA000000", null);
        context.drawText("Pause", new Vector(700, 500), new Font("Arial", Font.BOLD, 100), "#FFFFFF", 5);
    }

    private void drawGameBackground(GraphicContext context) {

        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AAAAAA", null);
    }

    private void createTask() {

        this.task = new TimerTask() {
            @Override
            public void run() {
                RenderLoop.this.loop();
            }
        };
    }

    private void startTimer() {

        this.isRunning = true;
        this.timer = new Timer(true);
        this.timer.scheduleAtFixedRate(this.task, 0, delay);
    }

    public boolean isRunning() {
        return isRunning;
    }

}
