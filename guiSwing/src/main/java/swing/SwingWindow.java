package swing;

import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JFrame {

    private JLayeredPane mainNode;
    private JPanel ui;

    public SwingWindow(Dimension size) {

        this.setSize(size.width, size.height);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIgnoreRepaint(true);
    }

}
