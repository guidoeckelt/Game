package de.charaktar.pointyandclicky.clicky;

import de.charaktar.game.graphic.ImageGraphic;
import de.charaktar.game.graphic.image.ImageContainer;

public class ClickySmileGraphic extends ImageGraphic {

    public ClickySmileGraphic(Clicky clicky, ImageContainer imageContainer) {

        super(clicky, imageContainer.loadImage("ClickySmileFrontPixel", "clicky\\Front_Smile_32x32.png"));
    }
}
