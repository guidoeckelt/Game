package game;

import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.metric.Dimension;

public interface Canvas {

    void clear();

    GraphicContext newGraphicContext();

    Dimension getViewport();

    GraphicContext newGraphicContext(Image currentImage);
}
