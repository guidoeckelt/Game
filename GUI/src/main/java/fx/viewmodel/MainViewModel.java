package fx.viewmodel;

import javafx.geometry.Dimension2D;
import game.TowerDefense;
import gameobject.GameObject;
import gameobject.tower.BuildStatus;
import gameobject.tower.Tower;
import gameobject.tower.impl.Gunner;
import javafx.stage.Stage;
import metric.Vector;

import java.util.LinkedList;

/**
 * Created by Guido on 05.05.2016.
 */
public class MainViewModel {

    private Stage mainWindow;
    private TowerDefense game;
    private LinkedList<Dimension2D> properSizes = new LinkedList<>();

    public MainViewModel(Stage primaryStage, TowerDefense game) {
        this.mainWindow = primaryStage;
        this.game = game;

        this.mainWindow.setResizable(false);
        this.mainWindow.setMaximized(true);
        this.initSuitableSizes();

//        this.game.start();
    }

    public void createNewPossibleTower(String name, double mouseX, double mouseY) {
        double x = (mouseX / game.getView().getFieldSize());
        double y = (mouseY / game.getView().getFieldSize());
        Vector suitablePosition = getSuitablePosition(x, y);
        Tower tower = new Gunner(new Vector(suitablePosition.getX(), suitablePosition.getY()));
        game.setToCreatingTower(tower);
    }

    public void updateNewPossibleTower(double mouseX, double mouseY) {
        double x = (mouseX / game.getView().getFieldSize());
        double y = (mouseY / game.getView().getFieldSize());
        Vector suitablePosition = getSuitablePosition(x, y);
        game.toCreatingTowerProperty().get().setPosition(suitablePosition);
    }

    public boolean isTowerOnFreeSpot() {
        if(game.getGameObjects().size() > 0){
            for(GameObject gameObject : game.getGameObjects()){
                if(game.toCreatingTowerProperty().get().intersects(gameObject)){
                    return false;
                }
            }
        }
        return true;
    }

    public void markTowerAsInvalid() {
        game.getToCreatingTower().setBuildStatus(BuildStatus.INVALID);
    }

    public void markTowerAsValid() {
        game.getToCreatingTower().setBuildStatus(BuildStatus.VALID);
    }

    public void addNewPossibleTower() {
        game.getToCreatingTower().setBuildStatus(BuildStatus.BUILD);
        game.addGameObject(game.getToCreatingTower());
        clearNewPossibleTower();
    }

    public void clearNewPossibleTower() {
        game.toCreatingTowerProperty().setValue(null);
    }

    private Vector getSuitablePosition(double rawX, double rawY) {
        Vector suitablePosition;
        double X = Math.round(rawX);
        double Y = Math.round(rawY);
        if (rawX != X || rawY != Y) {
            suitablePosition = new Vector(X, Y);
        } else {
            suitablePosition = new Vector(rawX, rawY);
        }
        return suitablePosition;
    }

    public Dimension2D getProperSize(double width, double height) {
        //return new Dimension2D(width, height);
        Dimension2D properSize;
        double properWidth = -1;
        double properHeight = -1;
        if (properSizes.contains(new Dimension2D(width, height))) {
            properSize = new Dimension2D(width, height);
        } else {
            for (Dimension2D size : properSizes) {
                if (properWidth < 0) {
                    if (size.getWidth() >= width) {
                        if (size.getWidth() == width) {
                            properWidth = width;
                        } else {
                            properWidth = properSizes.get(properSizes.indexOf(size) - 1).getWidth();
                        }
                    }

                    if (properSizes.getLast() == size) {
                        properWidth = properSizes.getLast().getWidth();
                    }
                }
                if (properHeight < 0) {
                    if (size.getHeight() >= height) {
                        if (size.getHeight() == height) {
                            properHeight = height;
                        } else {
                            properHeight = properSizes.get(properSizes.indexOf(size) - 1).getHeight();
                        }
                    }
                    if (properSizes.getLast() == size) {
                        properHeight = properSizes.getLast().getHeight();
                    }
                }
            }
            System.out.println("CanvasSize = " + properWidth + " : " + properHeight);
            properSize = new Dimension2D(properWidth, properHeight);
        }
        return properSize;
    }

    private void initSuitableSizes() {
        properSizes.add(new Dimension2D(800, 600));
        properSizes.add(new Dimension2D(1024, 768));
        properSizes.add(new Dimension2D(1280, 768));
        properSizes.add(new Dimension2D(1280, 830));
        properSizes.add(new Dimension2D(1280, 960));
        properSizes.add(new Dimension2D(1450, 1050));
        properSizes.add(new Dimension2D(1440, 900));
        properSizes.add(new Dimension2D(1600, 1200));
        properSizes.add(new Dimension2D(1900, 1080));
        properSizes.add(new Dimension2D(1900, 1200));
    }

    public TowerDefense getGame() {
        return game;
    }

}
