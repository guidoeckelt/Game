package de.charaktar.swing.input;

import de.charaktar.game.input.Mouse;
import de.charaktar.game.input.MouseButton;
import de.charaktar.game.metric.Vector;

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
    private List<MouseButton> buttonsPressed;
    private List<de.charaktar.game.input.MouseListener> listenerList;

    public SwingMouse(JFrame window) {
        this.window = window;
        this.posX = -1;
        this.posY = -1;
        this.buttonsPressed = new ArrayList<>();
        this.listenerList = new ArrayList<>();
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

                SwingMouse.this.updateButtons(e, true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                SwingMouse.this.updateButtons(e, false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

        });
    }


    @Override
    public void addListener(de.charaktar.game.input.MouseListener listener) {
        this.listenerList.add(listener);
    }

    @Override
    public void removeListener(de.charaktar.game.input.MouseListener listener) {
        this.listenerList.remove(listener);
    }

    @Override
    public Vector getPosition() {
        return new Vector(posX, posY);
    }

    private void updateButtons(MouseEvent e, boolean shouldAdd) {

        List<MouseButton> relevantButtons = SwingMouse.this.getRelevantButtons(e);
        for (MouseButton mouseButton : relevantButtons) {
            if (!SwingMouse.this.buttonsPressed.contains(mouseButton)) {
                if (shouldAdd) {
                    SwingMouse.this.buttonsPressed.add(mouseButton);
                }

            } else {
                if (!shouldAdd) {
                    SwingMouse.this.buttonsPressed.remove(mouseButton);
                }
            }
        }
        this.updateListeners();
    }

    private List<MouseButton> getRelevantButtons(MouseEvent e) {

        List<MouseButton> relevantButtons = new ArrayList<>();
        if (e.getButton() == MouseEvent.BUTTON1) {
            relevantButtons.add(MouseButton.LEFT);
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            relevantButtons.add(MouseButton.RIGHT);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            relevantButtons.add(MouseButton.MIDDLE);
        }
        return relevantButtons;
    }

    private void updatePosition(MouseEvent e) {

        this.updatePosition(e.getX(), e.getY());
    }

    private void updatePosition(int x, int y) {

        this.posX = x;
        this.posY = y;
//        System.out.println("mouse = "+ posX +" : "+ posY);
        this.updateListeners();
    }

    private void updateListeners() {
        de.charaktar.game.input.MouseEvent event = new de.charaktar.game.input.MouseEvent(new Vector(posX, posY), this.buttonsPressed);
        for (de.charaktar.game.input.MouseListener listener : listenerList) {
            listener.update(event);
        }
    }

}
