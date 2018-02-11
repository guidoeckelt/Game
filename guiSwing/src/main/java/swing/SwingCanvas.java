package swing;

import game.Canvas;
import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.metric.Dimension;
import swing.graphic.SwingGraphicContext;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SwingCanvas extends JPanel implements Canvas {

    private int width;
    private int height;

    public SwingCanvas(java.awt.Dimension size) {

        this.width = size.width;
        this.height = size.height;
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
    public GraphicContext newGraphicContext() {

        Graphics g2 = this.getGraphics().create(0, 0, this.width, this.height);
        return new SwingGraphicContext(g2, null);
    }

    @Override
    public GraphicContext newGraphicContext(Image currentImage) {
        Graphics g2 = this.getGraphics().create(0, 0, this.width, this.height);
        return new SwingGraphicContext(g2, currentImage);
    }

}
