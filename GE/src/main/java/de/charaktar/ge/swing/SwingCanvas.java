package de.charaktar.ge.swing;

import de.charaktar.ge.Camera;
import de.charaktar.ge.Canvas;
import de.charaktar.ge.DrawingContext;
import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.metric.Dimension;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
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
    public DrawingContext newDrawingContext(Camera camera) {

        SwingGraphicContext context = new SwingGraphicContext(this, camera);
        return new DrawingContext(context);
    }

    @Override
    public void draw(Image image) {

        Graphics2D g = (Graphics2D) this.buffer.getDrawGraphics();
        g.drawImage(image.getAwt(), 0, 0, null);
        this.buffer.show();
        g.dispose();
    }

    public void showWindow() {
        this.window.setCursor(this.defaultC);
        this.window.setTitle("PointyAndClicky");
        this.window.setVisible(true); // has to be visible before creating BufferStrategy
        this.window.createBufferStrategy(2); // see above
        this.buffer = this.window.getBufferStrategy();
    }

    private void createCursors() {
        String path = "D:\\DevGame\\PointyAndClicky\\media\\sprites\\cursor.png";
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.defaultC = this.toolkit.createCustomCursor(image, new Point(0, 0), "default P&C cursor");
    }

    public SwingWindow getWindow() {
        return window;
    }

}
