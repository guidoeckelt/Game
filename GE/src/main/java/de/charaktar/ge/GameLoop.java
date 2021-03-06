package de.charaktar.ge;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.movement.MovementParameter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameLoop {

    private Game game;
    private Timer timer;
    private TimerTask task;
    private long delay;
    private boolean isRunning;

    public GameLoop(Game game) {

        this.game = game;
        this.timer = new Timer(true);
        this.createTask();
        this.delay = 100;
        this.isRunning = false;
    }


    public void start() {

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

    private void startTimer() {

        this.isRunning = true;
        this.timer = new Timer(true);
        this.timer.scheduleAtFixedRate(this.task, 0, delay);
    }

    private void createTask() {

        this.task = new TimerTask() {
            @Override
            public void run() {
                GameLoop.this.loop();
            }
        };
    }

    private void loop() {

        GameStatus status = this.game.currentStatus();
        List<GameObject> gameObjects = status.getGameObjects();
        MovementParameter movementParameter = new MovementParameter(gameObjects);
        for (GameObject gameObject : gameObjects) {
            gameObject.update(movementParameter);
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }

}
