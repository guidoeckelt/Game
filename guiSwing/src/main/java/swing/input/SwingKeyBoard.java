package swing.input;

import game.input.KeyBoard;
import game.input.KeyBoardButton;
import game.input.KeyBoardEvent;
import game.input.KeyBoardListener;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class SwingKeyBoard implements KeyBoard {

    private List<KeyBoardListener> listeners;
    private List<KeyBoardButton> pressedButtons;

    public SwingKeyBoard(JFrame window) {

        this.listeners = new ArrayList<>();
        this.pressedButtons = new ArrayList<>();
        window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                SwingKeyBoard.this.keyReleased(e);
            }
        });
    }


    @Override
    public void addListener(KeyBoardListener listener) {

        this.listeners.add(listener);
    }

    @Override
    public void removeListener(KeyBoardListener listener) {

        this.listeners.remove(listener);
    }

    private void keyReleased(KeyEvent e) {

        KeyBoardButton released = this.getButton(e);
        this.updateListeners(released);
    }

    private KeyBoardButton getButton(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                return KeyBoardButton.ESCAPE;
            case KeyEvent.VK_UP:
                return KeyBoardButton.ARROW_UP;
            case KeyEvent.VK_DOWN:
                return KeyBoardButton.ARROW_DOWN;
            case KeyEvent.VK_LEFT:
                return KeyBoardButton.ARROW_LEFT;
            case KeyEvent.VK_RIGHT:
                return KeyBoardButton.ARROW_RIGHT;
            default:
                return KeyBoardButton.UNRECOGNIZED;
        }
    }

    private void updateListeners(KeyBoardButton released) {
        KeyBoardEvent event = new KeyBoardEvent(this.pressedButtons, released);
        for (KeyBoardListener listener : this.listeners) {
            listener.keyReleased(event);
        }
    }

}
