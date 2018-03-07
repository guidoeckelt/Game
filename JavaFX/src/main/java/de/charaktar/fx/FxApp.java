package de.charaktar.fx;
/**
 * Created by Guido on 05.05.2016.
 */

import de.charaktar.fx.view.MainView;
import de.charaktar.fx.viewmodel.MainViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxApp extends Application {

    private MainViewModel mainViewModel;
    private MainView mainView;
    private Stage primaryStage;
    private Scene mainScene;
    private Parent mainNode;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.mainViewModel = new MainViewModel(primaryStage, this.gameClass());
        this.mainView = new MainView(mainViewModel);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainView.fxml"));
        loader.setController(mainView);
        try {
            mainNode = loader.load();
            this.loadWindowAndStartApp();
        } catch (IOException e) {
            handleLoadException(e);
        }
    }

    protected Class gameClass() {
        return null;
    }

    private void loadWindowAndStartApp() {
        mainScene = new Scene(this.mainNode);
        primaryStage.setScene(mainScene);
        primaryStage.show();
        mainView.init();
    }

    private void handleLoadException(IOException e) {
        e.printStackTrace();
    }

}
