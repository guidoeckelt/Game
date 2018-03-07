package de.charaktar.ge.graphic;

import de.charaktar.ge.graphic.image.ImageContainer;

public interface Drawable {
    void createGraphics(ImageContainer imageContainer);

    Graphic currentGraphic();
}
