package game;

import game.Graphic.GraphicContext;
import game.metric.Dimension;

public interface Canvas {

    Dimension getViewport();

    void clear();

    GraphicContext newGraphicContext();

}
