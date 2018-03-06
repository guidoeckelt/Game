package de.charaktar.game.input;

import de.charaktar.game.metric.Vector;

public interface Mouse {

    Vector getPosition();

    void addListener(MouseListener listener);

    void removeListener(MouseListener listener);
}
