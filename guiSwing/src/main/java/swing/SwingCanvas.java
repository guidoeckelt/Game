package swing;

import game.Camera;
import game.Canvas;
import game.graphic.GraphicContext;
import game.metric.Dimension;
import swing.graphic.SwingGraphicContext;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class SwingCanvas implements Canvas {

    private Toolkit toolkit;
    private SwingWindow window;
    private BufferStrategy buffer;

    public SwingCanvas(Toolkit toolkit) {
        this.toolkit = toolkit;
        this.window = new SwingWindow(this.toolkit.getScreenSize());
    }

    @Override
    public Dimension getViewport() {

        return new Dimension((double) this.window.getWidth(), (double) this.window.getHeight());
    }

    @Override
    public void clear() {

        Graphics g = this.buffer.getDrawGraphics();
        g.clearRect(0, 0, this.window.getWidth(), this.window.getHeight());
    }

    @Override
    public GraphicContext newGraphicContext(Camera camera) {

        return new SwingGraphicContext(buffer, camera);
    }

    public void showWindow() {

        this.window.setVisible(true); // has to visible before creating BufferStrategy
        this.window.createBufferStrategy(2); // see above
        this.buffer = this.window.getBufferStrategy();
    }

    public SwingWindow getWindow() {
        return window;
    }

}
