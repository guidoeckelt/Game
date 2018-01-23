package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Window {

    private JFrame mainWindow;
    private JPanel mainNode;

    public Window(SwingCanvas canvas) {

        this.mainWindow = new JFrame();
        this.mainWindow.setTitle("PointyAndClicky");
        this.mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainWindow.setSize(1600, 1000);
        this.mainNode = new JPanel();
        this.mainNode.setSize(this.mainWindow.getWidth(), this.mainWindow.getHeight());
        this.mainNode.setBorder(new LineBorder(Color.black, 2));
//        this.mainNode.add(canvas);
//        this.mainWindow.add(this.mainNode);
        this.mainWindow.getContentPane().add(canvas);
    }

    public void show() {
        this.mainWindow.setVisible(true);
    }
}
