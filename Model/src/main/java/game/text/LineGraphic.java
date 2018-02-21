package game.text;


import game.graphic.DrawParameters;
import game.graphic.Graphic;
import game.metric.Dimension;
import game.metric.Vector;

import java.awt.*;


public class LineGraphic implements Graphic {

    private final Dimension lineMaxSize;
    private final Vector lineStart;
    private final int nameMaxWidth;
    private final String defaultColor;
    private final Font defaultNameFont;
    private final Font defaultContentFont;
    private Line line;

    public LineGraphic(Line line) {

        this.line = line;
        this.lineMaxSize = new Dimension(1500, 200);
        this.lineStart = new Vector(210, 780);
        this.nameMaxWidth = 300;
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
        Vector contentPosition = new Vector(this.lineStart.getX() + this.nameMaxWidth, this.lineStart.getY());
        drawParameters.getContext().drawText(nextLineContent, contentPosition, this.defaultContentFont, this.defaultColor, 2);
    }

}
