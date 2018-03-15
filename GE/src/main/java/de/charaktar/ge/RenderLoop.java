package de.charaktar.ge;

import de.charaktar.ge.graphic.image.Image;

@FunctionalInterface
public interface RenderLoop {

    Image tick();

}
