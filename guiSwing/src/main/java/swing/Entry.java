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

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        SwingCanvas canvas = new SwingCanvas(defaultToolkit.getScreenSize());
        Mouse mouse = new SwingMouse(canvas);
        KeyBoard keyBoard = new SwingKeyBoard(canvas);
        Speaker speaker = new Speaker();
        View view = new View(canvas);
        Game game = new Game(mouse, keyBoard, speaker);
        Window window = new Window(defaultToolkit.getScreenSize(), canvas);
        window.show();
        view.render(game);
        game.start();
        String filePath = "Rooted\\01 Titelnummer 1.wav";
//        speaker.play(filePath);
    }
}
