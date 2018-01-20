package gameobject.minion.impl;

import game.Graphic.Graphic;
import javafx.scene.paint.Color;
import metric.Vector;
import util.DrawParameters;

public class SquareGraphic extends Graphic<Square> {


    private Color color;
    private Vector visualOffset;

    public SquareGraphic(Square gameObject) {

        super(gameObject);
        this.visualOffset = new Vector(this.gameObject.getSize().getWidth() / 2, this.gameObject.getSize().getHeight() / 2);
        this.color = Color.rgb(1, 1, 0);
    }

    @Override
    public void draw(DrawParameters drawParameters) {

        double width = this.gameObject.getSize().getWidth() * drawParameters.getFieldSize();
        double height = this.gameObject.getSize().getHeight() * drawParameters.getFieldSize();
        double x = (this.gameObject.getPosition().getX() - this.visualOffset.getX()) * drawParameters.getFieldSize();
        double y = (this.gameObject.getPosition().getY() - this.visualOffset.getY()) * drawParameters.getFieldSize();

        drawParameters.getContext().setFill(this.color);
        drawParameters.getContext().fillRect(x, y, width, height);
    }

}
