package de.charaktar.fx.input;

import de.charaktar.ge.input.Mouse;
import de.charaktar.ge.input.MouseListener;
import de.charaktar.ge.metric.Vector;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FxMouse implements Mouse {

    private Stage mainWindow;
    private ArrayList<MouseListener> listenerList;
    private ArrayList<de.charaktar.ge.input.MouseButton> buttonsPressed;
    private double posY;
    private double posX;

    public FxMouse(Stage mainWindow) {
        this.mainWindow = mainWindow;
        this.listenerList = new ArrayList<>();
        this.buttonsPressed = new ArrayList<>();

        this.mainWindow.getScene().addEventHandler(MouseEvent.MOUSE_ENTERED, this::mouseEntered);
        this.mainWindow.getScene().addEventHandler(MouseEvent.MOUSE_MOVED, this::mouseMoved);
        this.mainWindow.getScene().addEventHandler(MouseEvent.MOUSE_CLICKED, this::mouseClicked);
        this.mainWindow.getScene().addEventHandler(MouseEvent.MOUSE_RELEASED, this::mouseReleased);
    }


    @Override
    public Vector getPosition() {
        return new Vector(posX, posY);
    }

    @Override
    public void addListener(MouseListener listener) {
        this.listenerList.add(listener);
    }

    @Override
    public void removeListener(MouseListener listener) {
        this.listenerList.add(listener);
    }

    private void mouseEntered(MouseEvent e) {

        this.updatePosition(e);
        this.updateListeners();
    }

    private void mouseMoved(MouseEvent e) {

        this.updatePosition(e);
        this.updateListeners();
    }

    private void mouseClicked(MouseEvent e) {

        this.addButton(e);
    }

    private void mouseReleased(MouseEvent e) {

        this.removeButton(e);
    }

    private void updateListeners() {

        de.charaktar.ge.input.MouseEvent event = new de.charaktar.ge.input.MouseEvent(new Vector(posX, posY), this.buttonsPressed);
        for (de.charaktar.ge.input.MouseListener listener : listenerList) {
            listener.update(event);
        }
    }

    private void updatePosition(MouseEvent e) {

        this.posX = e.getX();
        this.posY = e.getY();
//        System.out.println("mouse = "+ posX +" : "+ posY);
    }

    private void addButton(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            this.buttonsPressed.add(de.charaktar.ge.input.MouseButton.LEFT);
        } else if (e.getButton() == MouseButton.SECONDARY) {
            this.buttonsPressed.add(de.charaktar.ge.input.MouseButton.RIGHT);
        } else if (e.getButton() == MouseButton.MIDDLE) {
            this.buttonsPressed.add(de.charaktar.ge.input.MouseButton.MIDDLE);
        }
    }

    private void removeButton(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            this.buttonsPressed.remove(de.charaktar.ge.input.MouseButton.LEFT);
        } else if (e.getButton() == MouseButton.SECONDARY) {
            this.buttonsPressed.remove(de.charaktar.ge.input.MouseButton.RIGHT);
        } else if (e.getButton() == MouseButton.MIDDLE) {
            this.buttonsPressed.remove(de.charaktar.ge.input.MouseButton.MIDDLE);
        }
    }
}
