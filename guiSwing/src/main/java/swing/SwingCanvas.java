package swing;

import game.Camera;
import game.Canvas;
import game.graphic.GraphicContext;
import game.metric.Dimension;
import swing.graphic.SwingGraphicContext;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class SwingCanvas extends JPanel implements Canvas {

    private int width;
    private int height;
    private final BufferStrategy buffer;

    public SwingCanvas(JFrame frame, java.awt.Dimension size) {

        this.width = size.width;
        this.height = size.height;
        this.buffer = frame.getBufferStrategy();
        this.setSize(width, height);
        BufferedImage blankCursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                blankCursorImg, new Point(0, 0), "blank cursor");
        this.setCursor(blankCursor);
    }

    @Override
    public Dimension getViewport() {

        return new Dimension((double) width, (double) height);
    }

    @Override
    public void clear() {

        Graphics g = this.getGraphics().create();
        g.clearRect(0, 0, this.width, this.height);

    }

    @Override
    public GraphicContext newGraphicContext(Camera camera) {

        return new SwingGraphicContext(buffer, camera);
    }

    public void finalizeDrawing() {

        Graphics g = this.buffer.getDrawGraphics();
        g.dispose();
        buffer.show();
    }

}
