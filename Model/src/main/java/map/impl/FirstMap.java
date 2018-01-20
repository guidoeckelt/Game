package map.impl;

import level.Level;
import level.impl.FirstLevel;
import map.Map;
import map.WayPoint;
import metric.Dimension;
import metric.Vector;

/**
 * Created by Guido on 22.05.2016.
 */
public class FirstMap extends Map {

    public FirstMap() {
        gridSize = new Dimension(190, 80);
        //WayPoints
        Vector position = new Vector(this.gridSize.getWidth() - 2, this.gridSize.getHeight() / 2);
        WayPoint wayPoint = new WayPoint(position);
        wayPoints.addLast(wayPoint);
        position = new Vector(2, this.gridSize.getHeight() / 2);
        WayPoint wayPoint2 = new WayPoint(position, wayPoint);
        wayPoints.addFirst(wayPoint2);
    }

    protected void loadLevels() {
        Level level = new FirstLevel();
        levels.add(level);
    }
}
