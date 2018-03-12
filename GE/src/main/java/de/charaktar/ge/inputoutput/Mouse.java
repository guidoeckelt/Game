package de.charaktar.ge.inputoutput;

import de.charaktar.ge.metric.Vector;

public interface Mouse {

    Vector getPosition();

    void addListener(MouseListener listener);

    void removeListener(MouseListener listener);
}
