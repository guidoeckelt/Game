package game;

import game.graphic.GraphicContext;
import game.metric.Dimension;

public interface Canvas {

    Dimension getViewport();

    GraphicContext newGraphicContext(Camera camera);

}
