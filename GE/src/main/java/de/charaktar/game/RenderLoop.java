package de.charaktar.game;

import de.charaktar.game.graphic.image.Image;

import java.util.Timer;
import java.util.TimerTask;

public abstract class RenderLoop {

    private Timer timer;
    private TimerTask task;
    private long delay;
    private boolean isRunning;
    protected de.charaktar.game.Canvas canvas;
    protected Camera currentCamera;
    protected Image lastImage;

    public RenderLoop(de.charaktar.game.Canvas canvas, Camera camera, long delay) {

        this.canvas = canvas;
        this.currentCamera = camera;
        this.delay = delay;
        this.isRunning = false;
    }

    public void start() {

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

    protected abstract void loop();

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
