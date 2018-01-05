package map;

import metric.Vector;

import java.util.List;

/**
 * Created by Guido on 14.05.2016.
 */
public class WayPoint {

    private final Vector position;
    private final List<Vector> routeToNextWayPoint;
    private final WayPoint nextWayPoint;

    public WayPoint(Vector position) {
        this(position, null);
    }

    public WayPoint(Vector position, WayPoint nextWayPoint) {
        this.position = position;
        this.nextWayPoint = nextWayPoint;
        this.routeToNextWayPoint = calculateShortestPathToNextWayPoint(nextWayPoint);
    }

    private List<Vector> calculateShortestPathToNextWayPoint(WayPoint wayPoint){
        return  null;
    }

    public Vector getPosition() {
        return position;
    }

    public List<Vector> getRouteToNextWayPoint() {
        return routeToNextWayPoint;
    }

    public WayPoint getNextWayPoint() {
        return nextWayPoint;
    }

}
