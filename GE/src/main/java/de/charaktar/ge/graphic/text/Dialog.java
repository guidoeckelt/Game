package de.charaktar.ge.graphic.text;

import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.LineGraphic;

import java.util.List;

public class Dialog {

    private List<Line> lines;
    private Line currentLine;
    private LineGraphic graphic;

    public Dialog(List<Line> lines) {

        this.lines = lines;
        this.currentLine = this.lines.get(0);
        this.graphic = new LineGraphic(this.currentLine);
    }

    public Graphic getGraphic() {
        return graphic;
    }

}
