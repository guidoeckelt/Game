package de.charaktar.ge.inputoutput;

import de.charaktar.ge.metric.Vector;

public class MouseEvent {

    private Vector position;
    private MouseButton button;
    private int mouseWheelRotation;


    public MouseEvent(Vector position, MouseButton button) {
        this(position, button, 0);
    }

    public MouseEvent(Vector position, MouseButton button, int mouseWheelRotation) {
        this.position = position;
        this.button = button;
        this.mouseWheelRotation = mouseWheelRotation;
    }

    public Vector getPosition() {
        return position;
    }

    public MouseButton getButton() {
        return button;
    }

    public int getMouseWheelRotation() {
        return mouseWheelRotation;
    }
}
