package game.text;


import game.graphic.DrawParameters;
import game.graphic.Graphic;


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
        double x = 0;
        double y = this.lineStartY;
        drawParameters.getContext().drawText(name, x, y, this.defaultColor);
        String nextLineContent = this.line.getNextLineContent();
        x = this.nameEndX + 5;
        drawParameters.getContext().drawText(nextLineContent, x, y, this.defaultColor);

    }

}
