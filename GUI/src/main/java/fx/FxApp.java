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
        import game.TowerDefense;

        import java.io.IOException;

public class FxApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TowerDefense game = new TowerDefense();

        MainViewModel mainViewModel = new MainViewModel(primaryStage, game);
        MainView mainView = new MainView(mainViewModel);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainView.fxml"));
        loader.setController(mainView);
        Parent node = null;
        try {
            node = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(node));

        primaryStage.setResizable(false);
        primaryStage.setMaximized(true);
        primaryStage.show();
        mainView.initCanvas();
        game.start();
    }
}
