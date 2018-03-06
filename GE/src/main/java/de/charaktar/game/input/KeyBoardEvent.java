package de.charaktar.game.input;

import java.util.List;

public class KeyBoardEvent {

    private List<KeyBoardButton> pressedButtons;
    private KeyBoardButton releasedButton;

    public KeyBoardEvent(List<KeyBoardButton> pressedButtons, KeyBoardButton releasedButton) {

        this.pressedButtons = pressedButtons;
        this.releasedButton = releasedButton;
    }

    public List<KeyBoardButton> getPressedButtons() {
        return pressedButtons;
    }

    public KeyBoardButton getReleasedButton() {
        return releasedButton;
    }

}
