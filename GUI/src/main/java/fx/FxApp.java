package fx;
/**
 * Created by Guido on 05.05.2016.
 */

import fx.view.MainView;
import fx.viewmodel.MainViewModel;
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.mainViewModel = new MainViewModel(primaryStage);
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
