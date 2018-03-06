package de.charaktar.game.graphic;


import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;
import de.charaktar.game.text.Line;

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
    public void draw(DrawParameters drawParameters) {

        drawParameters.getContext().drawRect(lineStart, lineMaxSize, null, "#000000");

        String name = this.line.getSpeakerName();
        Vector namePosition = new Vector(this.lineStart.getX(), this.lineStart.getY());
        drawParameters.getContext().drawText(name + " :", namePosition, this.defaultNameFont, this.defaultColor, 3);

        String nextLineContent = this.line.getNextLineContent();
        Vector contentPosition = new Vector(this.lineStart.getX() + this.contentOffsetX, this.lineStart.getY());
        drawParameters.getContext().drawText(nextLineContent, contentPosition, this.defaultContentFont, this.defaultColor, 2);
    }

}
