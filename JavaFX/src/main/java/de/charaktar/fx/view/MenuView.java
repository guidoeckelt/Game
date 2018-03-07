package de.charaktar.fx.view;

import de.charaktar.fx.viewmodel.MenuViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Guido on 06.05.2016.
 */
public class MenuView implements Initializable {

    private final MenuViewModel viewModel;
    @FXML
    GridPane root;
    @FXML
    HBox container;
    @FXML
    ImageView towerGraphic;
    @FXML
    Label lblName;
    @FXML
    Label lblCost;
    @FXML
    Label lblDamage;
    @FXML
    Label lblAttackSpeed;

    public MenuView(MenuViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

    }

}
