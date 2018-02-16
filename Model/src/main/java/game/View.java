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
        int width = (int) this.canvas.getViewport().getWidth();
        int height = (int) this.canvas.getViewport().getHeight();
        Image canvasImage = new Image(width, height);
        this.drawBackground(canvasImage);
        if (game.getCurrentScene() != null) {
            this.drawGameObjects(game.getCurrentScene().getGameObjects(), canvasImage);
        }
        this.drawMouse(game.getMouse(), canvasImage);
        this.canvas.draw(canvasImage);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                renderLoop();
                this.cancel();
            }
        };
        timer.scheduleAtFixedRate(task, this.delay, 666);
    }


    private void drawBackground(Image currentImage) {
        for (int y = 0; y < currentImage.getHeight(); y++) {
            for (int x = 0; x < currentImage.getWidth(); x++) {
                currentImage.setPixel(x, y, 0xff000000);
            }
        }
    }

    private void drawGameObjects(List<GameObject> gameObjects, Image canvasImage) {
        for (GameObject gameObject : gameObjects) {
            if (!camera.isGameObjectVisible(gameObject)) {
                continue;
            }
            GraphicContext context = this.canvas.newGraphicContext(this.camera, canvasImage);
            DrawParameters drawParameters = new DrawParameters(context);
            Graphic graphic = gameObject.currentGraphic();
            graphic.draw(drawParameters);
        }
    }

    private void drawMouse(Mouse mouse, Image currentImage) {
        Vector position = mouse.getPosition();
        if (position.getX() < 0 || position.getY() < 0) {
            return;
        }
        Image image = this.game.getImageContainer().loadImage("Cursor", "cursor-2.png");
        currentImage.capture(image, (int) position.getX(), (int) position.getY());
    }

}
