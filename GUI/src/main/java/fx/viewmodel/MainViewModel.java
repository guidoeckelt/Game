package fx.viewmodel;

import fx.input.FxKeyBoard;
import fx.input.FxMouse;
import game.Game;
import game.input.KeyBoard;
import game.input.Mouse;
import game.metric.Dimension;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        this.mainWindow.initStyle(StageStyle.UNDECORATED);
        this.initSuitableSizes();
    }

    public void startGame() {
        Mouse mouse = new FxMouse(this.mainWindow);
        KeyBoard keyBoard = new FxKeyBoard(this.mainWindow);
        this.game = new Game(mouse, keyBoard);
        this.game.start();
    }

    public void end() {
        Platform.exit();
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
