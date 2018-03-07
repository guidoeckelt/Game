package de.charaktar.fx.input;

import de.charaktar.ge.input.KeyBoard;
import de.charaktar.ge.input.KeyBoardButton;
import de.charaktar.ge.input.KeyBoardListener;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FxKeyBoard implements KeyBoard {

    private Stage mainWindow;
    private ArrayList<KeyBoardListener> listenerList;
    private ArrayList<KeyBoardButton> buttonsPressed;

    public FxKeyBoard(Stage mainWindow) {

        this.mainWindow = mainWindow;
        this.listenerList = new ArrayList<>();
        this.buttonsPressed = new ArrayList<>();
    }

    @Override
    public void addListener(KeyBoardListener listener) {

    }

    @Override
    public void removeListener(KeyBoardListener listener) {

    }
}
