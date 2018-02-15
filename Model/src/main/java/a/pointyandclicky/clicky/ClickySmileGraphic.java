package a.pointyandclicky.clicky;

import game.graphic.ImageGraphic;
import game.graphic.image.ImageContainer;

public class ClickySmileGraphic extends ImageGraphic {

    public ClickySmileGraphic(Clicky clicky, ImageContainer imageContainer) {
        super(
                clicky,
                imageContainer.loadImage(
                        "ClickySmileFrontPixel"
                        , "clicky\\Front_Smile_32x32.png"
                        , (int) clicky.getSize().getWidth()
                        , (int) clicky.getSize().getHeight()
                )
        );
    }
}
