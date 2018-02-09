package game.input;

import game.metric.Vector;

public interface Mouse {

    Vector getPosition();

    void addListener(MouseListener listener);

    void removeListener(MouseListener listener);
}
