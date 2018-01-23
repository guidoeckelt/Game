package fx.view;

import fx.viewmodel.MainViewModel;
import fx.viewmodel.MenuViewModel;
import game.View;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Guido on 05.05.2016.
 */
public class MainView implements Initializable {

    @FXML
    AnchorPane root;
    @FXML
    StackPane sceneContainer;
    @FXML
    AnchorPane menuContainer;

    private game.Canvas canvas;
    private View view;
    private Canvas scene;
    private MenuControl menu;
    private MainViewModel viewModel;

    public MainView(MainViewModel viewModel) {

        this.viewModel = viewModel;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        menu = new MenuControl(new MenuViewModel());
//        menuContainer.getChildren().add(menu.getGraphic());
    }

    public void init() {
        this.scene = new Canvas(1200, 900);
        this.sceneContainer.getChildren().add(this.scene);
        this.canvas = new FxCanvas(scene);
        this.view = new View(this.canvas);
        this.viewModel.startGame();
        view.render(this.viewModel.getGame());
//        this.initScene();

    }

//    private void initScene() {
//        double width = sceneContainer.getBoundsInParent().getMaxX();
//        double height = sceneContainer.getBoundsInParent().getMaxY();
//        Dimension properSize = viewModel.getProperSize(width, height);
//        scene = new Canvas(properSize.getWidth(), properSize.getHeight());
//        scene.setOnDragEntered(dragEvent -> {
//            if (dragEvent.getDragboard().hasString()) {
//                String name = dragEvent.getDragboard().getString();
//                viewModel.createNewPossibleTower(name, dragEvent.getX(), dragEvent.getY());
//            }
//        });
//        scene.setOnDragOver(dragEvent -> {
//            viewModel.updateNewPossibleTower(dragEvent.getX(), dragEvent.getY());
//            if (dragEvent.getDragboard().hasString()) {
//                if (viewModel.isTowerOnFreeSpot()) {
//                    dragEvent.acceptTransferModes(TransferMode.ANY);
//                    viewModel.markTowerAsValid();
//                } else {
//                    viewModel.markTowerAsInvalid();
//                }
//            }
//            dragEvent.consume();
//        });
//        scene.setOnDragExited(dragEvent -> {
//            if (viewModel.getGame().toCreatingTowerProperty().get() != null) {
//                viewModel.clearNewPossibleTower();
//            }
//        });
//        scene.setOnDragDropped(dragEvent -> {
//            if (viewModel.isTowerOnFreeSpot()) {
//                viewModel.addNewPossibleTower();
//                dragEvent.setDropCompleted(true);
//            } else {
//                viewModel.clearNewPossibleTower();
//                dragEvent.setDropCompleted(false);
//            }
//        });
//    }

}
