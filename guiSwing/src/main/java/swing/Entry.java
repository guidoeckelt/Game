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
        Window window = new Window(defaultToolkit.getScreenSize());
        SwingCanvas canvas = new SwingCanvas(window, defaultToolkit.getScreenSize());
        Mouse mouse = new SwingMouse(window);
        KeyBoard keyBoard = new SwingKeyBoard(window);
        Speaker speaker = new Speaker();
        View view = new View(canvas);
        Game game = new Game(mouse, keyBoard, speaker);
        //start
        view.render(game);
        game.start();
    }
}
