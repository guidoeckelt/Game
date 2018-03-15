package de.charaktar.ge.inputoutput.input;

import de.charaktar.ge.inputoutput.Mouse;
import de.charaktar.ge.inputoutput.MouseButton;
import de.charaktar.ge.inputoutput.MouseButtonListener;
import de.charaktar.ge.metric.Vector;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class SwingMouse implements Mouse {

    private JFrame window;
    private int posX;
    private int posY;
    private MouseButton button;
    private List<de.charaktar.ge.inputoutput.MouseMotionListener> motionListeners;
    private List<de.charaktar.ge.inputoutput.MouseButtonListener> buttonListeners;

    public SwingMouse(JFrame window) {
        this.window = window;
        this.posX = -1;
        this.posY = -1;
        this.motionListeners = new ArrayList<>();
        this.buttonListeners = new ArrayList<>();
        this.window.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent e) {

                SwingMouse.this.updatePosition(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {

                SwingMouse.this.updatePosition(e);
            }

        });
        this.window.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {

                SwingMouse.this.updatePosition(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                SwingMouse.this.updatePosition(-1, -1);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                SwingMouse.this.button = SwingMouse.this.getRelevantButton(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                SwingMouse.this.updateButtons(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

        });
    }


    @Override
    public void addListener(de.charaktar.ge.inputoutput.MouseListener listener) {

        this.addMotionListener(listener);
        this.addButtonListener(listener);
    }

    @Override
    public void addMotionListener(de.charaktar.ge.inputoutput.MouseMotionListener listener) {

        this.motionListeners.add(listener);
    }

    @Override
    public void addButtonListener(MouseButtonListener listener) {

        this.buttonListeners.add(listener);
    }

    @Override
    public void removeListener(de.charaktar.ge.inputoutput.MouseListener listener) {

        this.removeMotionListener(listener);
        this.removeButtonListener(listener);
    }

    @Override
    public void removeMotionListener(de.charaktar.ge.inputoutput.MouseMotionListener listener) {

        this.motionListeners.remove(listener);
    }

    @Override
    public void removeButtonListener(MouseButtonListener listener) {

        this.buttonListeners.remove(listener);
    }

    @Override
    public Vector getPosition() {
        return new Vector(posX, posY);
    }

    private void updateButtons(MouseEvent e) {

        this.updateListeners(true);
        this.button = null;
    }

    private MouseButton getRelevantButton(MouseEvent e) {

        List<MouseButton> relevantButtons = new ArrayList<>();
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                return MouseButton.LEFT;
            case MouseEvent.BUTTON2:
                return MouseButton.RIGHT;
            case MouseEvent.BUTTON3:
                return MouseButton.MIDDLE;
            default:
                return MouseButton.LEFT;
        }
    }

    private void updatePosition(MouseEvent e) {

        this.updatePosition(e.getX(), e.getY());
    }

    private void updatePosition(int x, int y) {

        this.posX = x;
        this.posY = y;
        this.updateListeners(false);
    }

    private void updateListeners(boolean isAction) {
        de.charaktar.ge.inputoutput.MouseEvent event = new de.charaktar.ge.inputoutput.MouseEvent(new Vector(posX, posY), this.button);
        if (isAction) {
            for (de.charaktar.ge.inputoutput.MouseButtonListener listener : this.buttonListeners) {
                listener.onAction(event);
            }
        } else {
            for (de.charaktar.ge.inputoutput.MouseMotionListener listener : this.motionListeners) {
                listener.onMove(event);
            }
        }
    }

}
