package de.charaktar.pointyandclicky;

import de.charaktar.game.Game;
import de.charaktar.game.View;
import de.charaktar.game.input.KeyBoard;
import de.charaktar.game.input.Mouse;
import de.charaktar.game.media.Speaker;
import de.charaktar.swing.SwingCanvas;
import de.charaktar.swing.input.SwingKeyBoard;
import de.charaktar.swing.input.SwingMouse;

import java.awt.*;

public class SwingEntry {

    public static void main(String[] args) {

        //init
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        SwingCanvas canvas = new SwingCanvas(defaultToolkit);
        Mouse mouse = new SwingMouse(canvas.getWindow());
        KeyBoard keyBoard = new SwingKeyBoard(canvas.getWindow());
        Speaker speaker = new Speaker();
        View view = new View(canvas);
        Game game = new PointyAndClicky(mouse, keyBoard, speaker);
        //start
        canvas.showWindow();
        view.render(game);
        game.start();
    }

}
