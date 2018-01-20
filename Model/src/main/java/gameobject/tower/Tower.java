package gameobject.tower;

import gameobject.GameObject;
import gameobject.minion.Minion;
import javafx.scene.input.DataFormat;
import metric.Dimension;
import metric.Vector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guido on 06.05.2016.
 */
public abstract class Tower extends GameObject implements Serializable {

    public static DataFormat BASIC = new DataFormat("main.java.model.gameobject.gameobject.Tower.Tower");

    protected String name;
    protected int cost;
    protected double dmg;
    protected double attackSpeed;
    protected double range;

    protected BuildStatus buildStatus;
    protected int level = 1;
    protected int maxLevel;
    protected List<Minion> minionsInRange = new ArrayList<>();

    public Tower(Vector position) {
        super(position, new Dimension(2, 2));
        name = "Tower";
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public double getDmg() {
        return dmg;
    }

    public double getRange() {
        return range;
    }

    public BuildStatus getBuildStatus() {
        return buildStatus;
    }

    public void setBuildStatus(BuildStatus buildStatus) {
        this.buildStatus = buildStatus;
    }
}
