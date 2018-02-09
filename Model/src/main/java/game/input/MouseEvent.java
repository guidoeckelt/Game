package game.input;

import game.metric.Vector;

import java.util.List;

public class MouseEvent {

    private Vector position;
    private List<MouseButton> button;
    private int mouseWheelRotation;


    public MouseEvent(Vector position, List<MouseButton> button) {
        this(position, button, 0);
    }

    public MouseEvent(Vector position, List<MouseButton> button, int mouseWheelRotation) {
        this.position = position;
        this.button = button;
        this.mouseWheelRotation = mouseWheelRotation;
    }

    public Vector getPosition() {
        return position;
    }

    public List<MouseButton> getButton() {
        return button;
    }

    public int getMouseWheelRotation() {
        return mouseWheelRotation;
    }
}
