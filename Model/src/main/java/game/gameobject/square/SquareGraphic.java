package game.gameobject.square;

import game.Graphic.DrawParameters;
import game.Graphic.Graphic;
import game.metric.Vector;
import javafx.scene.paint.Color;

public class SquareGraphic extends Graphic {

    private Color color;
    private Vector visualOffset;

    public SquareGraphic(Square gameObject) {

        super(gameObject);
        this.visualOffset = new Vector(this.gameObject.getSize().getWidth() / 2, this.gameObject.getSize().getHeight() / 2);
        this.color = Color.rgb(0, 0, 0);
    }

    @Override
    public void draw(DrawParameters drawParameters) {

        double width = this.gameObject.getSize().getWidth();
        double height = this.gameObject.getSize().getHeight();
        double x = this.gameObject.getPosition().getX();
        double y = this.gameObject.getPosition().getY();

//        drawParameters.getContext().setSize(width, height);
        drawParameters.getContext().drawRect(x, y, width, height, "#ff0000", null);
    }

}
