package swing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SwingWindow extends JFrame {

    private JLayeredPane mainNode;
    private JPanel ui;

    public SwingWindow(Dimension size) {

        this.setTitle("PointyAndClicky");
        this.setSize(size.width, size.height);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIgnoreRepaint(true);
        BufferedImage blankCursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                blankCursorImg, new Point(0, 0), "blank cursor");
        this.setCursor(blankCursor);

        this.mainNode = new JLayeredPane();
        this.mainNode.setSize(this.getWidth(), this.getHeight());

        this.ui = new JPanel();
        this.ui.setSize(size.width, size.height);
        this.ui.setBorder(new LineBorder(Color.white, 3));
        this.ui.setBackground(Color.green);
        this.ui.setOpaque(true);

//        this.mainNode.setLayer(canvas, 0);
//        this.mainNode.setLayer(this.ui, 1);
//        this.mainNode.add(this.ui, BorderLayout.CENTER);
        this.getContentPane().add(this.mainNode, BorderLayout.CENTER);
    }

}
