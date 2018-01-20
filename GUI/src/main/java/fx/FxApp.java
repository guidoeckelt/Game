package fx;
/**
 * Created by Guido on 05.05.2016.
 */

import fx.view.MainView;
import fx.viewmodel.MainViewModel;
import game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxApp extends Application {

    private MainViewModel mainViewModel;
    private MainView mainView;
    private FXMLLoader loader;
    private Stage primaryStage;
    private Scene mainScene;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Game game = new Game();
        this.mainViewModel = new MainViewModel(primaryStage, game);
        this.mainView = new MainView(mainViewModel);

        loader = new FXMLLoader(getClass().getResource("/View/MainView.fxml"));
        loader.setController(mainView);
        Parent mainNode;
        try {
            mainNode = loader.load();
            this.loadWindowAndStartApp(mainNode);
        } catch (IOException e) {
            handleLoadException(e);
        }
    }

    private void loadWindowAndStartApp(Parent node) {
        mainScene = new Scene(node);
        primaryStage.setScene(mainScene);
        this.mainViewModel.init();
        this.mainView.init();
        primaryStage.show();

    }

    private void handleLoadException(IOException e) {
        e.printStackTrace();
    }

}
