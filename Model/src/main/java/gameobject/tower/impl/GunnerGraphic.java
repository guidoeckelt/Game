package gameobject.tower.impl;

import game.Graphic.Graphic;
import gameobject.tower.BuildStatus;
import javafx.scene.paint.Color;
import metric.Vector;
import util.DrawParameters;

public class GunnerGraphic extends Graphic<Gunner> {

    private Color color;
    private Vector visualOffset;

    public GunnerGraphic(Gunner gameObject) {

        super(gameObject);
        this.visualOffset = new Vector(this.gameObject.getSize().getWidth() / 2, this.gameObject.getSize().getHeight() / 2);
        this.color = Color.color(0, 1, 0);
    }

    @Override
    public void draw(DrawParameters drawParameters) {
        if (this.gameObject.getBuildStatus() == BuildStatus.INVALID) {
            drawParameters.getContext().setFill(Color.RED);
        } else if (this.gameObject.getBuildStatus() == BuildStatus.VALID) {
            drawParameters.getContext().setFill(Color.DARKGREEN);
        } else if (this.gameObject.getBuildStatus() == BuildStatus.BUILD) {
            drawParameters.getContext().setFill(this.color);
        }
        double width = this.gameObject.getSize().getWidth() * drawParameters.getFieldSize();
        double height = this.gameObject.getSize().getHeight() * drawParameters.getFieldSize();
        double x = (this.gameObject.getPosition().getX() - this.visualOffset.getX()) * drawParameters.getFieldSize();
        double y = (this.gameObject.getPosition().getY() - this.visualOffset.getY()) * drawParameters.getFieldSize();
        drawParameters.getContext().fillRect(x, y, width, height);

    }
}
