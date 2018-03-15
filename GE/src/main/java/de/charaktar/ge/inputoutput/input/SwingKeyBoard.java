package de.charaktar.ge.inputoutput.input;

import de.charaktar.ge.inputoutput.KeyBoard;
import de.charaktar.ge.inputoutput.KeyBoardButton;
import de.charaktar.ge.inputoutput.KeyBoardEvent;
import de.charaktar.ge.inputoutput.KeyBoardListener;

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

        KeyBoardButton released = this.getRelevantButton(e);
        this.updateListeners(released);
    }

    private KeyBoardButton getRelevantButton(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                return KeyBoardButton.ESCAPE;
            case KeyEvent.VK_F1:
                return KeyBoardButton.F1;
            case KeyEvent.VK_F2:
                return KeyBoardButton.F2;
            case KeyEvent.VK_F3:
                return KeyBoardButton.F3;
            case KeyEvent.VK_F4:
                return KeyBoardButton.F4;
            case KeyEvent.VK_F5:
                return KeyBoardButton.F5;
            case KeyEvent.VK_F6:
                return KeyBoardButton.F6;
            case KeyEvent.VK_F7:
                return KeyBoardButton.F7;
            case KeyEvent.VK_F8:
                return KeyBoardButton.F8;
            case KeyEvent.VK_F9:
                return KeyBoardButton.F9;
            case KeyEvent.VK_F10:
                return KeyBoardButton.F10;
            case KeyEvent.VK_F11:
                return KeyBoardButton.F11;
            case KeyEvent.VK_F12:
                return KeyBoardButton.F12;
            case KeyEvent.VK_CIRCUMFLEX:
                return KeyBoardButton.CIRCUMFLEX;
            case KeyEvent.VK_1:
                return KeyBoardButton.N_1;
            case KeyEvent.VK_2:
                return KeyBoardButton.N_2;
            case KeyEvent.VK_3:
                return KeyBoardButton.N_3;
            case KeyEvent.VK_4:
                return KeyBoardButton.N_4;
            case KeyEvent.VK_5:
                return KeyBoardButton.N_5;
            case KeyEvent.VK_6:
                return KeyBoardButton.N_6;
            case KeyEvent.VK_7:
                return KeyBoardButton.N_7;
            case KeyEvent.VK_8:
                return KeyBoardButton.N_8;
            case KeyEvent.VK_9:
                return KeyBoardButton.N_9;
            case KeyEvent.VK_0:
                return KeyBoardButton.N_0;
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
