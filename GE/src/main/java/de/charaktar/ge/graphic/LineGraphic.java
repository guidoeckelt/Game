package de.charaktar.ge.graphic;


import de.charaktar.ge.graphic.text.Line;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;

import java.awt.*;


public class LineGraphic implements Graphic {

    private final Dimension lineMaxSize;
    private final Vector lineStart;
    private final int contentOffsetX;
    private final String defaultColor;
    private final Font defaultNameFont;
    private final Font defaultContentFont;
    private Line line;

    public LineGraphic(Line line) {

        this.line = line;
        this.lineMaxSize = new Dimension(1500, 200);
        this.lineStart = new Vector(210, 780);
        this.contentOffsetX = 300;
        this.defaultColor = "#FFFFFF";
        this.defaultNameFont = new Font("Arial", Font.BOLD, 50);
        this.defaultContentFont = new Font("Arial", Font.BOLD, 40);
    }

    @Override
    public void draw(GraphicContext graphicContext) {

        graphicContext.strokeRect(lineStart, lineMaxSize, "#000000", 2);

        String name = this.line.getSpeakerName();
        Vector namePosition = new Vector(this.lineStart.getX(), this.lineStart.getY());
        graphicContext.fillText(name + " :", namePosition, this.defaultNameFont, this.defaultColor);
        graphicContext.strokeText(name + " :", namePosition, this.defaultNameFont, "#000000", 3);

        String nextLineContent = this.line.getNextLineContent();
        Vector contentPosition = new Vector(this.lineStart.getX() + this.contentOffsetX, this.lineStart.getY());
        graphicContext.fillText(nextLineContent, contentPosition, this.defaultContentFont, this.defaultColor);
        graphicContext.strokeText(nextLineContent, contentPosition, this.defaultContentFont, "#000000", 3);
    }

}
