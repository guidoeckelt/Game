package de.charaktar.pointyandclicky.gameobject.pointy;

import de.charaktar.ge.graphic.ImageGraphic;
import de.charaktar.ge.graphic.image.ImageContainer;

public class PointySmileGraphic extends ImageGraphic {

    public PointySmileGraphic(Pointy pointy, ImageContainer imageContainer) {

        super(pointy, imageContainer.loadImage("PointyFrontSmilePixel", "pointy\\Front_Smile_32x32.png"));
    }
}
