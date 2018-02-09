package fx.input;

import game.input.KeyBoard;
import game.input.MouseListener;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FxKeyBoard implements KeyBoard {

    private Stage mainWindow;
    private ArrayList<MouseListener> listenerList;
    private ArrayList<game.input.MouseButton> buttonsPressed;

    public FxKeyBoard(Stage mainWindow) {

        this.mainWindow = mainWindow;
        this.listenerList = new ArrayList<>();
        this.buttonsPressed = new ArrayList<>();
    }

}
