package game.text;

import game.graphic.Graphic;

import java.util.List;

public class Conversation {

    private List<Line> lines;
    private Line currentLine;
    private LineGraphic graphic;

    public Conversation(List<Line> lines) {

        this.lines = lines;
        this.currentLine = this.lines.get(0);
        this.graphic = new LineGraphic(this.currentLine);
    }

    public Graphic getGraphic() {
        return graphic;
    }

}
