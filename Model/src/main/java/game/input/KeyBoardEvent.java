package game.input;

import java.util.List;

public class KeyBoardEvent {

    private List<KeyBoardButton> pressedButtons;

    public KeyBoardEvent(List<KeyBoardButton> pressedButtons) {
        this.pressedButtons = pressedButtons;
    }
}
