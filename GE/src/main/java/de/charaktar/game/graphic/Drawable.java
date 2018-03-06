package de.charaktar.game.graphic;

import de.charaktar.game.graphic.image.ImageContainer;

public interface Drawable {
    void createGraphics(ImageContainer imageContainer);

    Graphic currentGraphic();
}
