package swing;

import game.Game;
import game.View;
import game.input.KeyBoard;
import game.input.Mouse;
import swing.input.SwingKeyBoard;
import swing.input.SwingMouse;

public class Entry {

    public static void main(String[] args) {

        SwingCanvas canvas = new SwingCanvas(1200, 900);
        Mouse mouse = new SwingMouse(canvas);
        KeyBoard keyBoard = new SwingKeyBoard(canvas);
        View view = new View(canvas);
        Game game = new Game(mouse, keyBoard);
        Window window = new Window(canvas);
        window.show();
        view.render(game);
        game.start();
    }
}
