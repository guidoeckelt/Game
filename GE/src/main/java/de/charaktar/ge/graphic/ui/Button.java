package de.charaktar.ge.graphic.ui;

import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class Button extends UIElement {

    private Font defaultFont = new Font("Arial", Font.BOLD, 100);
    private String defaultTextFill = "#FFFFFF";

    private String text;
    private Font font;
    private String textFill;
    private double textStrokeWidth;

    private ActionHandler handler;


    public Button(String text, Vector position) {

        this(text, null, position, new Dimension(-1, -1));
    }

    public Button(String text, Dimension size) {

        this(text, null, new Vector(-1, -1), size);
    }

    public Button(String text, ActionHandler handler) {

        this(text, handler, new Vector(0, 0));
    }

    public Button(String text, ActionHandler handler, Vector position) {

        this(text, handler, position, new Dimension(-1, -1));
    }

    public Button(String text, ActionHandler handler, Dimension size) {

        this(text, handler, new Vector(-1, -1), size);
    }

    public Button(String text, ActionHandler handler, Vector position, Dimension size) {

        super(position, size);
        this.text = text;
        this.font = this.defaultFont;
        this.textFill = this.defaultTextFill;
        this.textStrokeWidth = 4;
        this.handler = handler;
    }

    public void setOnAction(ActionHandler handler) {
        this.handler = handler;
    }

    @Override
    public void draw(GraphicContext graphicContext) {

        graphicContext.fillRect(this.getPosition(), this.getSize(), this.background.getColor());
        graphicContext.strokeRect(this.getPosition(), this.getSize(), this.border.getColor(), this.border.getWidth());

        Rectangle2D textBounds = this.font.getStringBounds(this.text, new FontRenderContext(null, true, false));
        double offsetX = Math.abs((this.getSize().getWidth() / 2) - (textBounds.getWidth() / 2));
        double offsetY = Math.abs((this.getSize().getHeight() / 2) - (textBounds.getHeight() / 2));
        Vector offsetPos = new Vector(this.position.getX() + offsetX, this.position.getY() + offsetY);
        graphicContext.fillText(this.text, offsetPos, this.font, this.textFill);
        graphicContext.strokeText(this.text, offsetPos, this.font, "#000000", this.textStrokeWidth);

    }

}
