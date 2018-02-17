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

        double width = this.square.getSize().getWidth();
        double height = this.square.getSize().getHeight();
        double x = this.square.getPosition().getX();
        double y = this.square.getPosition().getY();

        drawParameters.getContext().drawRect(x, y, width, height, "0xFFFFFF", null);
    }

}
