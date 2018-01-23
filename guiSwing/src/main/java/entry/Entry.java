package entry;

import game.Game;
import game.View;
import gui.SwingCanvas;
import gui.Window;

public class Entry {

    public static void main(String[] args) {

        SwingCanvas canvas = new SwingCanvas(1200, 900);
        View view = new View(canvas);
        Game game = new Game();
        Window window = new Window(canvas);
        window.show();
        view.render(game);
        game.start();
    }
}
