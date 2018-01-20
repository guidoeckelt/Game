package util;

import gameobject.GameObject;
import gameobject.tower.Tower;

import java.util.List;

/**
 * Created by Guido on 14.05.2016.
 */
public class ViewParameters {

    private final List<GameObject> toDrawingGameObjects;
    private final Tower toCreatingTower;

    public ViewParameters(List<GameObject> toDrawingGameObjects, Tower toCreatingTower) {
        this.toDrawingGameObjects = toDrawingGameObjects;
        this.toCreatingTower = toCreatingTower;
    }

    public List<GameObject> getToDrawingGameObjects() {
        return toDrawingGameObjects;
    }

    public Tower getToCreatingTower() {
        return toCreatingTower;
    }
}
