package de.charaktar.ge;

import de.charaktar.ge.inputoutput.InputOutputDevices;
import de.charaktar.ge.inputoutput.KeyBoard;
import de.charaktar.ge.inputoutput.Mouse;
import de.charaktar.ge.inputoutput.Speaker;
import de.charaktar.ge.inputoutput.input.SwingKeyBoard;
import de.charaktar.ge.inputoutput.input.SwingMouse;
import de.charaktar.ge.swing.SwingCanvas;

import java.awt.*;

public abstract class GEApplication {

    protected InputOutputDevices io;
    private SwingCanvas canvas;
    protected View view;

    public GEApplication(String[] args) {

        this.checkArgs(args);
        this.init();
    }

    private void checkArgs(String[] args) {

    }

    public void init() {

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        this.canvas = new SwingCanvas(defaultToolkit);
        Speaker speaker = new Speaker();
        Mouse mouse = new SwingMouse(this.canvas.getWindow());
        KeyBoard keyBoard = new SwingKeyBoard(this.canvas.getWindow());
        this.io = new InputOutputDevices(mouse, keyBoard, speaker);
        this.view = new View(this.canvas, this.io);
    }

    public View start() {

        this.canvas.showWindow();
        this.view.render();
        return this.view;
    }

    public abstract Game createGameClass();

}
