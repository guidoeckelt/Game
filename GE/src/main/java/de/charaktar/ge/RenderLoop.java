package de.charaktar.ge;

import de.charaktar.ge.graphic.image.Image;

public abstract class RenderLoop {

    protected de.charaktar.ge.Canvas canvas;

    public RenderLoop(de.charaktar.ge.Canvas canvas) {

        this.canvas = canvas;
    }

    protected abstract Image loop();

}
