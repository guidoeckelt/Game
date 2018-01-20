package fx.viewmodel;

import gameobject.tower.Tower;
import gameobject.tower.impl.Gunner;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import metric.Vector;

/**
 * Created by Guido on 06.05.2016.
 */
public class MenuViewModel {

    private ObjectProperty<Tower> firstTower = new SimpleObjectProperty<>();

    public MenuViewModel() {
        firstTower.setValue(new Gunner(new Vector(0, 0)));
    }

    public Tower getFirstTower() {
        return firstTower.get();
    }

    public ObjectProperty<Tower> firstTowerProperty() {
        return firstTower;
    }
}
