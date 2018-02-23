package swing;

import game.Game;
import game.View;
import game.input.KeyBoard;
import game.input.Mouse;
import game.media.Speaker;
import swing.input.SwingKeyBoard;
import swing.input.SwingMouse;

import java.awt.*;

public class Entry {

    public static void main(String[] args) {

        //init
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        SwingCanvas canvas = new SwingCanvas(defaultToolkit);
        Mouse mouse = new SwingMouse(canvas.getWindow());
        KeyBoard keyBoard = new SwingKeyBoard(canvas.getWindow());
        Speaker speaker = new Speaker();
        View view = new View(canvas);
        Game game = new Game(mouse, keyBoard, speaker);
        //start
        canvas.showWindow();
        view.render(game);
        game.start();
    }
}
