package a.pointyandclicky.pointy;

import game.graphic.SpriteGraphic;
import game.graphic.image.ImageContainer;

import java.util.Arrays;

public class PointyRotationGraphic extends SpriteGraphic {

    public PointyRotationGraphic(Pointy pointy, ImageContainer imageContainer) {
        super(pointy
                , Arrays.asList(
                        imageContainer.loadImage("PointyFrontSmilePixel", "pointy\\Front_Smile_32x32.png")
                        , imageContainer.loadImage("PointyFrontRightSmilePixel", "pointy\\FrontRight_Smile_32x32.png")
                        , imageContainer.loadImage("PointyRightSmilePixel", "pointy\\Right_Smile_32x32.png")
                        , imageContainer.loadImage("PointyBackRightSmilePixel", "pointy\\BackRight_32x32.png")
                        , imageContainer.loadImage("PointyBackSmilePixel", "pointy\\Back_32x32.png")
                        , imageContainer.loadImage("PointyBackLeftSmilePixel", "pointy\\BackLeft_32x32.png")
                        , imageContainer.loadImage("PointyLeftSmilePixel", "pointy\\Left_Smile_32x32.png")
                        , imageContainer.loadImage("PointyFrontLeftSmilePixel", "pointy\\FrontLeft_Smile_32x32.png")
                )
                , 1000);
    }

}
