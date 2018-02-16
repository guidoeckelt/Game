package swing;

import game.Camera;
import game.Canvas;
import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.graphic.image.MemoryImageConverter;
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
    public GraphicContext newGraphicContext(Camera camera, Image currentImage) {

        return new SwingGraphicContext(camera, currentImage);
    }

    public void draw(Image image) {

//        this.clear();
        java.awt.Image imageAwt = new MemoryImageConverter(image).intoAwt();
        Graphics g = this.getGraphics().create();
        g.drawImage(imageAwt, 0, 0, image.getWidth(), image.getHeight(), null);
    }

}
