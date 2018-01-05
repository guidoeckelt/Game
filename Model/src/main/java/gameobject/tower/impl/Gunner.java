package gameobject.tower.impl;

import javafx.scene.paint.Color;
import gameobject.tower.BuildStatus;
import gameobject.tower.Tower;
import util.DrawParamaters;
import metric.Vector;

/**
 * Created by Guido on 08.05.2016.
 */
public class Gunner extends Tower {

    public Gunner(Vector position) {
        super(position);
        this.name = "Gunner";
        this.cost = 50;
        this.dmg = 10;
        this.attackSpeed = 3;
        this.range = 5;
        this.maxLevel = 3;

        this.color = Color.color(0, 1, 0);
    }

    @Override
    public void updateVisual() {
        this.visualMeasurePoint = new Vector(position.getX() - (size.getWidth() / 2), position.getY() - (size.getHeight() / 2));
    }

    @Override
    public void draw(DrawParamaters drawParamaters) {
        if (buildStatus == BuildStatus.INVALID) {
            drawParamaters.getContext().setFill(Color.RED);
        } else if (buildStatus == BuildStatus.VALID) {
            drawParamaters.getContext().setFill(Color.DARKGREEN);
        } else if (buildStatus == BuildStatus.BUILD) {
            drawParamaters.getContext().setFill(color);
        }
        double width = this.size.getWidth() * drawParamaters.getFieldSize();
        double height = this.size.getHeight() * drawParamaters.getFieldSize();
        double x = this.visualMeasurePoint.getX() * drawParamaters.getFieldSize();
        double y = this.visualMeasurePoint.getY() * drawParamaters.getFieldSize();
        drawParamaters.getContext().fillRect(x, y, width, height);
    }

}
