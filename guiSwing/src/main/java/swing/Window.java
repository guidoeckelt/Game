package swing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window {

    private JFrame mainWindow;
    private JLayeredPane mainNode;
    private JPanel ui;

    public Window(Dimension size, SwingCanvas canvas) {

        this.mainWindow = new JFrame();
        this.mainWindow.setTitle("PointyAndClicky");
        this.mainWindow.setSize(size.width, size.height);
        this.mainWindow.setUndecorated(true);
        this.mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.mainNode = new JLayeredPane();
        this.mainNode.setSize(this.mainWindow.getWidth(), this.mainWindow.getHeight());

        this.ui = new JPanel();
        this.ui.setSize(size.width, size.height);
        this.ui.setBorder(new LineBorder(Color.white, 3));
        this.ui.setBackground(Color.green);
        this.ui.setOpaque(true);
        BufferedImage blankCursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                blankCursorImg, new Point(0, 0), "blank cursor");
        this.ui.setCursor(blankCursor);

//        this.mainNode.setLayer(canvas, 0);
//        this.mainNode.setLayer(this.ui, 1);
//        this.mainNode.add(this.ui, BorderLayout.CENTER);
        this.mainNode.add(canvas);
        this.mainWindow.getContentPane().add(this.mainNode, BorderLayout.CENTER);
    }

    public void show() {
        this.mainWindow.setVisible(true);
    }
}
