package de.charaktar.ge.graphic.ui;

import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

public abstract class UIElement implements Graphic {

    protected Background defaultBackground = new Background("#BBBBBB");
    protected Border defaultBorder = new Border("#000000", 3);

    protected Vector position;
    protected Dimension size;
    protected Background background;
    protected Border border;

    public UIElement() {

        this(new Vector(0, 0), new Dimension(0, 0));
    }

    public UIElement(Vector position, Dimension size) {

        this.position = position;
        this.size = size;
        this.background = this.defaultBackground;
        this.border = this.defaultBorder;
    }

    @Override
    public void draw(GraphicContext graphicContext) {

    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

}
