package game;

import game.graphic.GraphicContext;
import game.graphic.image.Image;
import game.metric.Dimension;

public interface Canvas {

    void clear();

    Dimension getViewport();

    GraphicContext newGraphicContext(Camera camera, Image currentImage);

    void draw(Image currentScene);
}
