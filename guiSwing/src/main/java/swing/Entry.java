package swing;

import game.Game;
import game.View;
import game.input.KeyBoard;
import game.input.Mouse;
import swing.input.SwingKeyBoard;
import swing.input.SwingMouse;

import java.awt.*;

public class Entry {

    public static void main(String[] args) {

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        SwingCanvas canvas = new SwingCanvas(defaultToolkit.getScreenSize());
        Mouse mouse = new SwingMouse(canvas);
        KeyBoard keyBoard = new SwingKeyBoard(canvas);
        View view = new View(canvas);
        Game game = new Game(mouse, keyBoard);
        Window window = new Window(defaultToolkit.getScreenSize(), canvas);
        window.show();
        view.render(game);
        game.start();
    }
}
