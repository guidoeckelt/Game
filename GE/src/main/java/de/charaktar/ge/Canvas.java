package de.charaktar.ge;

import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.metric.Dimension;

public interface Canvas {

    Dimension getViewport();

    GraphicContext newGraphicContext(Camera camera);

}
