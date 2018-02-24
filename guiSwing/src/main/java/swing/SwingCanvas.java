package swing;

import game.Camera;
import game.Canvas;
import game.graphic.GraphicContext;
import game.metric.Dimension;
import swing.graphic.SwingGraphicContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class SwingCanvas implements Canvas {

    private Toolkit toolkit;
    private SwingWindow window;
    private BufferStrategy buffer;
    private Cursor defaultC;

    public SwingCanvas(Toolkit toolkit) {
        this.toolkit = toolkit;
        this.window = new SwingWindow(this.toolkit.getScreenSize());
        this.createCursors();
    }

    @Override
    public Dimension getViewport() {

        return new Dimension((double) this.window.getWidth(), (double) this.window.getHeight());
    }

    @Override
    public GraphicContext newGraphicContext(Camera camera) {

        return new SwingGraphicContext(buffer, camera);
    }

    public void showWindow() {
        this.window.setCursor(this.defaultC);
        this.window.setTitle("PointyAndClicky");
        this.window.setVisible(true); // has to be visible before creating BufferStrategy
        this.window.createBufferStrategy(2); // see above
        this.buffer = this.window.getBufferStrategy();
    }

    public SwingWindow getWindow() {
        return window;
    }

    private void createCursors() {
        String path = "D:\\DevGame\\PointyAndClicky\\media\\sprites\\cursor.png";
        Image image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.defaultC = this.toolkit.createCustomCursor(image, new Point(0, 0), "default P&C cursor");
    }

}
