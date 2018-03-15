package a.test.square;

import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.metric.Vector;
import javafx.scene.paint.Color;

public class SquareGraphic implements Graphic {

    private Color color;
    private Vector visualOffset;
    private Square square;

    public SquareGraphic(Square square) {

        this.square = square;
        this.visualOffset = new Vector(square.getSize().getWidth() / 2, square.getSize().getHeight() / 2);
        this.color = Color.rgb(0, 0, 0);
    }

    @Override
    public void draw(GraphicContext graphicContext) {

        graphicContext.fillRect(this.square.getPosition(), this.square.getSize(), "#FFFFFF");
    }

}
