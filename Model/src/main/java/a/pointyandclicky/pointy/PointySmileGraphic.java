package a.pointyandclicky.pointy;

import game.graphic.ImageGraphic;
import game.graphic.image.ImageContainer;

public class PointySmileGraphic extends ImageGraphic {

    public PointySmileGraphic(Pointy pointy, ImageContainer imageContainer) {

        super(pointy, imageContainer.loadImage("PointyFrontSmilePixel", "pointy\\Front_Smile_32x32.png"));
    }
}
