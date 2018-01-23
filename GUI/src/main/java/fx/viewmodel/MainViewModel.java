package fx.viewmodel;

import game.Game;
import game.metric.Dimension;
import game.metric.Vector;
import javafx.stage.Stage;

import java.util.LinkedList;

/**
 * Created by Guido on 05.05.2016.
 */
public class MainViewModel {

    private Stage mainWindow;
    private Game game;
    private LinkedList<Dimension> properSizes = new LinkedList<>();

    public MainViewModel(Stage primaryStage) {
        this.mainWindow = primaryStage;

        this.mainWindow.setResizable(false);
        this.mainWindow.setMaximized(true);
        this.initSuitableSizes();
    }

    public void startGame() {
        this.game = new Game();
        this.game.start();
    }

//    public void createNewPossibleTower(String name, double mouseX, double mouseY) {
//        double x = (mouseX / game.getView().getFieldSize());
//        double y = (mouseY / game.getView().getFieldSize());
//        Vector suitablePosition = getSuitablePosition(x, y);
//        Tower tower = new Gunner(new Vector(suitablePosition.getX(), suitablePosition.getY()));
//        game.setToCreatingTower(tower);
//    }
//
//    public void updateNewPossibleTower(double mouseX, double mouseY) {
//        double x = (mouseX / game.getView().getFieldSize());
//        double y = (mouseY / game.getView().getFieldSize());
//        Vector suitablePosition = getSuitablePosition(x, y);
//        game.toCreatingTowerProperty().get().setPosition(suitablePosition);
//    }
//
//    public boolean isTowerOnFreeSpot() {
//        if (game.getGameObjects().size() > 0) {
//            for (GameObject gameObject : game.getGameObjects()) {
//                if (game.toCreatingTowerProperty().get().intersects(gameObject)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public void markTowerAsInvalid() {
//        game.getToCreatingTower().setBuildStatus(BuildStatus.INVALID);
//    }
//
//    public void markTowerAsValid() {
//        game.getToCreatingTower().setBuildStatus(BuildStatus.VALID);
//    }
//
//    public void addNewPossibleTower() {
//        game.getToCreatingTower().setBuildStatus(BuildStatus.BUILD);
//        game.addGameObject(game.getToCreatingTower());
//        clearNewPossibleTower();
//    }
//
//    public void clearNewPossibleTower() {
//        game.toCreatingTowerProperty().setValue(null);
//    }

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

    public Dimension getProperSize(double width, double height) {
        Dimension properSize;
        double properWidth = -1;
        double properHeight = -1;
        if (properSizes.contains(new Dimension(width, height))) {
            properSize = new Dimension(width, height);
        } else {
            for (Dimension properSizeComparison : properSizes) {
                if (properHeight < 0) {
                    if (properSizeComparison.getHeight() >= height) {
                        if (properSizeComparison.getHeight() == height) {
                            properHeight = height;
                        }
                    }
                    if (properSizes.getLast() == properSizeComparison) {
                        properHeight = properSizes.getLast().getHeight();
                    }
                }
                if (properWidth < 0) {
                    if (properSizeComparison.getWidth() >= width) {
                        if (properSizeComparison.getWidth() == width) {
                            properWidth = width;
                        }
                    }

                    if (properSizes.getLast() == properSizeComparison) {
                        properWidth = properSizes.getLast().getWidth();
                    }
                }

            }
            System.out.println("CanvasSize = " + properWidth + " : " + properHeight);
            properSize = new Dimension(properWidth, properHeight);
        }
        return new Dimension(1200, 800);
//        return properSize;
    }

    private void initSuitableSizes() {
        properSizes.add(new Dimension(800, 600));
        properSizes.add(new Dimension(1024, 768));
        properSizes.add(new Dimension(1280, 768));
        properSizes.add(new Dimension(1280, 830));
        properSizes.add(new Dimension(1280, 960));
        properSizes.add(new Dimension(1450, 1050));
        properSizes.add(new Dimension(1440, 900));
        properSizes.add(new Dimension(1600, 1200));
        properSizes.add(new Dimension(1900, 1080));
        properSizes.add(new Dimension(1900, 1200));
    }

    public Game getGame() {
        return game;
    }

}
