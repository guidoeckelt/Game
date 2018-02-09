package swing.input;

import game.input.Mouse;
import game.input.MouseButton;
import game.metric.Vector;
import swing.SwingCanvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class SwingMouse implements Mouse {

    private SwingCanvas canvas;
    private int posX;
    private int posY;
    private List<MouseButton> buttonsPressed;
    private List<game.input.MouseListener> listenerList;

    public SwingMouse(SwingCanvas canvas) {
        this.canvas = canvas;
        this.posX = -1;
        this.posY = -1;
        this.buttonsPressed = new ArrayList<>();
        this.listenerList = new ArrayList<>();
        this.canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

                updatePosition(e);
                updateListeners();
            }
        });
        this.canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {
                    buttonsPressed.add(MouseButton.LEFT);
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    buttonsPressed.add(MouseButton.RIGHT);
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    buttonsPressed.add(MouseButton.MIDDLE);
                }
                updateListeners();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {
                    buttonsPressed.remove(MouseButton.LEFT);
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    buttonsPressed.remove(MouseButton.RIGHT);
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    buttonsPressed.remove(MouseButton.MIDDLE);
                }
                updateListeners();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                updatePosition(e);
                updateListeners();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                posX = -1;
                posY = -1;
            }
        });
    }

    private void updateListeners() {
        game.input.MouseEvent event = new game.input.MouseEvent(new Vector(posX, posY), this.buttonsPressed);
        for (game.input.MouseListener listener : listenerList) {
            listener.update(event);
        }
    }

    @Override
    public void addListener(game.input.MouseListener listener) {
        this.listenerList.add(listener);
    }

    @Override
    public void removeListener(game.input.MouseListener listener) {
        this.listenerList.remove(listener);
    }

    private void updatePosition(MouseEvent e) {

        posX = e.getX();
        posY = e.getY();
//        System.out.println("mouse = "+ posX +" : "+ posY);
    }

    @Override
    public Vector getPosition() {
        return new Vector(posX, posY);
    }
}
