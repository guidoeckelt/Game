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
    private Image image;

    private int offset;

    public View(Canvas canvas) {

        this.timer = new Timer(true);
        this.delay = 10;

        this.canvas = canvas;
        this.camera = new Camera(new Vector(0, 0), canvas.getViewport());

        this.image = new Image("D:\\Bildas\\teamSucksButInISayNothing.jpg");
        this.offset = 0;
    }

    public void render(Game game) {
        this.game = game;
        this.renderLoop();
    }

    private void renderLoop() {
        int width = (int) this.canvas.getViewport().getWidth();
        int height = (int) this.canvas.getViewport().getHeight();
        Image currentImage = new Image(width, height);
        this.drawBackground(currentImage);
        this.drawGameObjects(game.getCurrentScene().getGameObjects(), currentImage);
        this.drawMouse(game.getMouse(), currentImage);
//        currentImage.capture(this.image, this.offset,10);
        GraphicContext context = this.canvas.newGraphicContext();
        context.drawImage(currentImage, 0, 0);

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

    private void drawGameObjects(List<GameObject> gameObjects, Image currentImage) {
        for (GameObject gameObject : gameObjects) {
            GraphicContext context = this.canvas.newGraphicContext(currentImage);
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
