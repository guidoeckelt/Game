package de.charaktar.ge;

import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.metric.Dimension;

public interface Canvas {

    Dimension getViewport();

    DrawingContext newDrawingContext(Camera camera);

    void draw(Image image);

}
