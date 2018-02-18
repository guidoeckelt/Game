package game.text;


import game.graphic.DrawParameters;
import game.graphic.Graphic;
import game.metric.Vector;


public class LineGraphic implements Graphic {

    private final int nameEndX;
    private final int lineStartY;
    private final String defaultColor;
    private Line line;

    public LineGraphic(Line line) {

        this.line = line;
        this.nameEndX = 200;
        this.lineStartY = 600;
        this.defaultColor = "#FF0000";
    }

    @Override
    public void draw(DrawParameters drawParameters) {

        String name = this.line.getSpeakerName();
        Vector namePosition = new Vector(0, this.lineStartY);
        drawParameters.getContext().drawText(name, namePosition, this.defaultColor);

        String nextLineContent = this.line.getNextLineContent();
        Vector contentPosition = new Vector(this.nameEndX + 5, this.lineStartY);
        drawParameters.getContext().drawText(nextLineContent, contentPosition, this.defaultColor);
    }

}
