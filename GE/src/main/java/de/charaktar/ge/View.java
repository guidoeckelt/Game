package de.charaktar.ge;

import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.inputoutput.InputOutputDevices;
import de.charaktar.ge.inputoutput.MouseEvent;
import de.charaktar.ge.inputoutput.MouseListener;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Guido on 05.05.2016.
 */
public class View implements MouseListener {

    private int imageCounter;
    private long lastFPSOutput;
    private Canvas canvas;
    private InputOutputDevices io;
    private RenderLoop defaultStart;
    private RenderLoop renderLoop;
    private Timer timer;

    public View(Canvas canvas, InputOutputDevices io) {

        this.canvas = canvas;
        this.io = io;
        this.imageCounter = 0;
        this.lastFPSOutput = new Date().getTime();
    }

    public void render() {

        this.defaultStart = new DefaultStartRenderLoop(this.canvas);
        this.io.getMouse().addListener(this);
        this.cancelTimerIfNecessary();
        this.startRenderLoop(this.defaultStart, 10);
    }

    public void render(Game game) {

        this.cancelTimerIfNecessary();
        this.renderLoop = new DefaultGameRenderLoop(this.canvas, game);
        this.startRenderLoop(this.renderLoop, 16);
    }

    private void cancelTimerIfNecessary() {

        if (this.timer != null) {
            this.timer.cancel();
        }
    }

    private void startRenderLoop(RenderLoop renderLoop, int delay) {

        this.timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                View.this.fpsCounter();
                Image image = renderLoop.tick();
                View.this.canvas.draw(image);
            }
        }, 0, delay);
    }

    private void fpsCounter() {

        Date now = new Date();
        if (now.getTime() - this.lastFPSOutput > 1000) {
//            System.out.println(this.imageCounter);
            this.lastFPSOutput = now.getTime();
            this.imageCounter = 0;
        } else {
            this.imageCounter++;
        }
    }

    @Override
    public void onAction(MouseEvent event) {

    }

    @Override
    public void onMove(MouseEvent event) {

    }
}
