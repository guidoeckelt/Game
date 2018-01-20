package game;

import gameobject.GameObject;
import gameobject.minion.impl.Square;
import gameobject.tower.Tower;
import interfaces.movement.MovementParameter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metric.Vector;

import java.util.*;

/**
 * Created by Guido on 11.05.2016.
 */
public class Game {

    private View view;
    //Objects
    private ObservableList<GameObject> gameObjects = FXCollections.observableArrayList();

    //GameLoop
    private Timer timer;
    private long delay;
    private TimerTask gameLoop;

    //MenuInfo
    private ObjectProperty<Tower> toCreatingTower = new SimpleObjectProperty<>();


    public Game() {
        this.view = new View();
        this.delay = 100;
        this.timer = new Timer();
        this.gameLoop = new TimerTask() {
            @Override
            public void run() {
                gameLoop();
            }
        };

        GameObject square = new Square(new Vector(50, 50));
        this.addGameObject(square);

//        GameObject gameObject = new TestImageGameObject(new Vector(10, 10), new Dimension(10, 10));
//        this.addGameObject(gameObject);
//        int scale = 5;
//        gameObject = new TestSpriteGameObject(new Vector(100, 100), new Dimension(30*scale, 19*scale));
//        this.addGameObject(gameObject);
    }

    private void gameLoop() {

        this.updateAllGameObjects();
    }

    private void updateAllGameObjects() {
        List<GameObject> tempList = new ArrayList<>(this.gameObjects);
        MovementParameter movementParameter = new MovementParameter(gameObjects);
        for (GameObject gameObject : tempList) {
            gameObject.update(movementParameter);
        }
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
        gameObject.createGraphics();
    }

    private void removeGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public void start() {
        view.render(this);
        timer.scheduleAtFixedRate(gameLoop, 0, delay);
    }

    public View getView() {
        return view;
    }

    public List<GameObject> getGameObjects() {
        return Collections.unmodifiableList(this.gameObjects);
    }

    public Tower getToCreatingTower() {
        return toCreatingTower.get();
    }

    public void setToCreatingTower(Tower toCreatingTower) {
        this.toCreatingTower.set(toCreatingTower);
    }

    public ObjectProperty<Tower> toCreatingTowerProperty() {
        return toCreatingTower;
    }
}
