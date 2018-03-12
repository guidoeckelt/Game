package de.charaktar.ge;

import de.charaktar.ge.inputoutput.InputOutputDevices;
import de.charaktar.ge.inputoutput.KeyBoard;
import de.charaktar.ge.inputoutput.Mouse;
import de.charaktar.ge.inputoutput.Speaker;
import de.charaktar.ge.swing.SwingCanvas;
import de.charaktar.ge.swing.input.SwingKeyBoard;
import de.charaktar.ge.swing.input.SwingMouse;

import java.awt.*;

public abstract class Bootstrapper {

    protected InputOutputDevices io;
    protected View view;

    public Bootstrapper(String[] args) {

        this.init(args);
    }

    public void init(String[] args) {

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        SwingCanvas canvas = new SwingCanvas(defaultToolkit);
        this.view = new View(canvas);
        Speaker speaker = new Speaker();
        Mouse mouse = new SwingMouse(canvas.getWindow());
        KeyBoard keyBoard = new SwingKeyBoard(canvas.getWindow());
        this.io = new InputOutputDevices(speaker, mouse, keyBoard);
        canvas.showWindow();
    }

    public void start() {
        view.render();
        Game game = this.createGameClass();
        view.render(game);
        game.start();
    }

    protected abstract Game createGameClass();

}
