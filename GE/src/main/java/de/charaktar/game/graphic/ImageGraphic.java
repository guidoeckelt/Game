package de.charaktar.game.graphic;

import de.charaktar.game.gameobject.GameObject;
import de.charaktar.game.graphic.image.MemoryImageConverter;
import de.charaktar.game.graphic.image.Pixel;
import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

public class ImageGraphic implements Graphic {

    private de.charaktar.game.graphic.image.Image image;
    private GameObject gameObject;

    public ImageGraphic(GameObject gameObject, de.charaktar.game.graphic.image.Image image) {

        this.gameObject = gameObject;
        this.image = image;
    }

    @Override
    public void draw(DrawParameters drawParameters) {
        double x = this.gameObject.getPosition().getX();
        double y = this.gameObject.getPosition().getY();

        if (drawParameters.isHovered(this.gameObject)) {
            ImageGraphic.drawImageHoverBorder(drawParameters.getContext(), image, this.gameObject.getPosition(), this.gameObject.getSize());
        }
        drawParameters.getContext().drawImage(image, this.gameObject.getPosition(), this.gameObject.getSize());
    }

    public static void drawImageHoverBorder(GraphicContext context, de.charaktar.game.graphic.image.Image image, Vector position, Dimension size) {

        java.awt.Image source = new MemoryImageConverter(image).intoAwt();
        ImageProducer prod = new FilteredImageSource(source.getSource(), new RGBImageFilter() {
            @Override
            public int filterRGB(int x, int y, int rgb) {
                Pixel pixel = new Pixel(rgb);
                if (pixel.getAlpha() == 0)
                    return 0;
                else
                    return 0xFFFFA500;
            }
        });
        java.awt.Image tempImg = Toolkit.getDefaultToolkit().createImage(prod);
        BufferedImage blurredImage = new BufferedImage((int) size.getWidth(), (int) size.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = blurredImage.createGraphics();
        g.drawImage(tempImg, 0, 0, blurredImage.getWidth(), blurredImage.getHeight(), null);
        g.dispose();
        int offset = 10;
        int dWidth = blurredImage.getWidth() + (offset * 2);
        int dHeight = blurredImage.getHeight() + (offset * 2);
        int offsetX = (dWidth - blurredImage.getWidth()) / 2;
        int offsetY = (dHeight - blurredImage.getHeight()) / 2;
        BufferedImage scaledBlurredImage = de.charaktar.game.graphic.image.Image.scale(blurredImage, dWidth, dHeight);
        Vector shadowPosition = new Vector(position.getX() - offsetX, position.getY() - offsetY);
        Dimension shadowSize = new Dimension(scaledBlurredImage.getWidth(), scaledBlurredImage.getHeight());
        context.drawImage(new de.charaktar.game.graphic.image.Image(scaledBlurredImage), shadowPosition, shadowSize);
    }

}
