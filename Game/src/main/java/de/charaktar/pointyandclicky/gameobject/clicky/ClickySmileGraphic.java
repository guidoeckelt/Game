package de.charaktar.pointyandclicky.gameobject.clicky;

import de.charaktar.ge.graphic.ImageGraphic;
import de.charaktar.ge.graphic.image.ImageContainer;

public class ClickySmileGraphic extends ImageGraphic {

    public ClickySmileGraphic(Clicky clicky, ImageContainer imageContainer) {

        super(clicky, imageContainer.loadImage("ClickySmileFrontPixel", "clicky\\Front_Smile_32x32.png"));
    }
}
