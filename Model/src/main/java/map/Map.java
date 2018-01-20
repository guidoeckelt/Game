package map;

import level.Level;
import metric.Dimension;

import java.util.LinkedList;

/**
 * Created by Guido on 22.05.2016.
 */
public abstract class Map {

    protected Dimension gridSize;
    protected LinkedList<WayPoint> wayPoints = new LinkedList<>();
    protected LinkedList<Level> levels = new LinkedList<>();
    protected Level currentLevel;

    public Map() {
        loadLevels();
        loadNextLevel();
    }

    protected void loadNextLevel() {
        if (currentLevel != null) {
            if (currentLevel != levels.getLast()) {
                currentLevel = levels.get(levels.indexOf(currentLevel) + 1);
            } else {
                currentLevel = levels.getLast();
            }
        } else {
            currentLevel = levels.getFirst();
        }
    }

    protected abstract void loadLevels();

    public Dimension getGridSize() {
        return gridSize;
    }

    public LinkedList<WayPoint> getWayPoints() {
        return wayPoints;
    }

    public LinkedList<Level> getLevels() {
        return levels;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }
}
