package de.charaktar.ge.inputoutput;

import de.charaktar.ge.metric.Vector;

public interface Mouse {

    Vector getPosition();

    void addListener(MouseListener listener);

    void addMotionListener(MouseMotionListener listener);

    void addButtonListener(MouseButtonListener listener);

    void removeListener(MouseListener listener);

    void removeMotionListener(MouseMotionListener listener);

    void removeButtonListener(MouseButtonListener listener);

}
