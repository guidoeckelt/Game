package game;

import game.Graphic.ImageContainer;
import game.gameobject.GameObject;
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
    private Scene currentScene;
    //GameLoop
    private Timer timer;
    private TimerTask gameLoop;
    private long delay;

    public Game() {

        this.imageContainer = new ImageContainer();
        this.currentScene = new Scene(imageContainer, new Dimension(2000, 1000));

        this.timer = new Timer(true);
        this.gameLoop = new TimerTask() {
            @Override
            public void run() {
                gameLoop();
            }
        };
        this.delay = 100;
    }


    public void start() {
        this.gameLoop();
        timer.scheduleAtFixedRate(gameLoop, 0, delay);
    }

    public void pause() {

    }

    private void gameLoop() {

        this.updateAllGameObjects();
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
}
