package game.graphic;

import game.graphic.image.ImageContainer;

public interface Drawable {
    void createGraphics(ImageContainer imageContainer);

    Graphic currentGraphic();
}
