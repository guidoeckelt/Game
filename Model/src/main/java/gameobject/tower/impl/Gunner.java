package gameobject.tower.impl;

import gameobject.tower.Tower;
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

//        this.graphics = new GunnerGraphic(this);
    }

}
