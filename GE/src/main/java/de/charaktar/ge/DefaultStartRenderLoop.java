package de.charaktar.ge;

import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.metric.Vector;

public class DefaultStartRenderLoop extends RenderLoop {

    public DefaultStartRenderLoop(Canvas canvas) {

        super(canvas);
    }

    @Override
    protected Image loop() {

        Camera camera = new Camera(new Vector(0, 0), this.canvas.getViewport());
        GraphicContext context = this.canvas.newGraphicContext(camera);
        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#000000", null);
        return context.end();
    }

}
