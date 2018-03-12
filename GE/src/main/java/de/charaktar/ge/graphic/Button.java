package de.charaktar.ge.graphic;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class Button extends GameObject implements Graphic {

    private String defaultBorder = "#000000";
    private String defaultFill = "#BBBBBB";
    private Font defaultFont = new Font("Arial", Font.PLAIN, 80);
    private String defaultTextFill = "#FFFFFF";

    private String text;
    private Font font;
    private String textFill;

    public Button(String text, Vector position) {

        this(text, position, new Dimension(520, 100));
    }

    public Button(String text, Vector position, Dimension size) {
        super(position, size);
        this.text = text;
        this.font = this.defaultFont;
        this.textFill = this.defaultTextFill;
    }

    @Override
    public void draw(DrawParameters drawParameters) {

        GraphicContext context = drawParameters.getContext();
        if (drawParameters.isHovered(this)) {
            context.drawRect(this.getPosition(), this.getSize(), "#FFA500", this.defaultBorder);
        } else {
            context.drawRect(this.getPosition(), this.getSize(), this.defaultFill, defaultBorder);
        }

        Rectangle2D bounds = this.font.getStringBounds(this.text, new FontRenderContext(null, false, false));
        double offsetX = (this.getSize().getWidth() / 2) - (bounds.getWidth() / 2);
        double offsetY = (this.getSize().getHeight() / 2) - (bounds.getHeight() / 2);
        Vector offsetPos = new Vector(this.position.getX() + offsetX, this.position.getY() + offsetY);
        context.drawText(this.text, offsetPos, this.font, this.textFill, 3);

    }

}
