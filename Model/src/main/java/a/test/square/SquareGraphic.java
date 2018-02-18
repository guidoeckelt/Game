package a.test.square;

import game.graphic.DrawParameters;
import game.graphic.Graphic;
import game.metric.Vector;
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
    public void draw(DrawParameters drawParameters) {

        drawParameters.getContext().drawRect(
                this.square.getPosition(), this.square.getSize()
                , "0xFFFFFF", null);
    }

}
