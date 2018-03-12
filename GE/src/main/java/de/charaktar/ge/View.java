package de.charaktar.ge;

import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.metric.Vector;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Guido on 05.05.2016.
 */
public class View {

    private Canvas canvas;
    private RenderLoop renderLoop;

    public View(Canvas canvas) {

        this.canvas = canvas;
    }

    public void render() {

        this.renderLoop = new DefaultStartRenderLoop(canvas);
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                FutureTask<Image> task = new FutureTask<>(View.this.renderLoop::loop);
                View.this.runTask(task);
            }
        }, 0, 10);
    }

    public void render(Game game) {

        Camera camera = new Camera(new Vector(0, 0), this.canvas.getViewport());
        this.renderLoop = new DefaultGameRenderLoop(this.canvas, camera, game);
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                FutureTask<Image> task = new FutureTask<>(View.this.renderLoop::loop);
                View.this.runTask(task);
            }
        }, 0, 10);
    }

    private void runTask(FutureTask<Image> task) {
        task.run();
        try {
            Image image = task.get();
            this.canvas.show(image);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
