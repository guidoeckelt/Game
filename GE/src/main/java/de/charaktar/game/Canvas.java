package de.charaktar.game;

import de.charaktar.game.graphic.GraphicContext;
import de.charaktar.game.metric.Dimension;

public interface Canvas {

    Dimension getViewport();

    GraphicContext newGraphicContext(Camera camera);

}
