package game;

import game.gameobject.GameObject;
import game.graphic.image.ImageContainer;
import game.input.KeyBoard;
import game.input.Mouse;
import game.input.MouseButton;
import game.input.MouseEvent;
import game.media.Speaker;
import game.metric.Dimension;
import game.movement.MovementParameter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Guido on 11.05.2016.
 */
public class Game {

    private ImageContainer imageContainer;
    private Mouse mouse;
    private KeyBoard keyBoard;
    private Speaker speaker;
    private Scene currentScene;
    //GameLoop
    private Timer timer;
    private TimerTask gameLoop;
    private long delay;

    public Game(Mouse mouse, KeyBoard keyBoard, Speaker speaker) {

        this.imageContainer = new ImageContainer();
        this.mouse = mouse;
        this.keyBoard = keyBoard;
        this.speaker = speaker;
        this.currentScene = new Scene(imageContainer, new Dimension(2000, 1000));

        this.timer = new Timer(true);
        this.gameLoop = new TimerTask() {
            @Override
            public void run() {
                gameLoop();
            }
        };
        this.delay = 100;

        this.mouse.addListener(this::mouseMove);
    }

    public void start() {
        timer.scheduleAtFixedRate(gameLoop, 0, delay);
    }

    public void pause() {
        timer.cancel();
    }

    public void unpause() {
        this.gameLoop = new TimerTask() {
            @Override
            public void run() {
                gameLoop();
            }
        };
        timer.scheduleAtFixedRate(gameLoop, 0, delay);
    }

    private void gameLoop() {

        this.updateAllGameObjects();
    }

    public void mouseMove(MouseEvent event) {
        if (event.getButton().contains(MouseButton.MIDDLE)) {
            System.out.println("mitte");
        }
    }

    private void updateAllGameObjects() {

        List<GameObject> gameObjects = this.currentScene.getGameObjects();
        MovementParameter movementParameter = new MovementParameter(gameObjects);
        for (GameObject gameObject : gameObjects) {
            gameObject.update(movementParameter);
        }
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public ImageContainer getImageContainer() {
        return imageContainer;
    }
}
