package de.charaktar.fx.view;

import de.charaktar.fx.FxCanvas;
import de.charaktar.fx.viewmodel.MainViewModel;
import de.charaktar.fx.viewmodel.MenuViewModel;
import de.charaktar.ge.View;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.lang.reflect.InvocationTargetException;
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

    private de.charaktar.ge.Canvas canvas;
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
        try {
            this.viewModel.startGame();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        view.render(this.viewModel.getGame());
//        this.initScene();

    }

}
