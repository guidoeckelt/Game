package gui;

import game.Canvas;
import game.Graphic.GraphicContext;
import game.metric.Dimension;

import javax.swing.*;
import java.awt.*;

public class SwingCanvas extends JPanel implements Canvas {

    private int width;
    private int height;

    public SwingCanvas(int width, int height) {

        this.width = width;
        this.height = height;
        this.setSize(width, height);
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
        return new SwingGraphicContext(g2);
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
    }
}
