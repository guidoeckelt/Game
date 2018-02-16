package game;

import game.gameobject.GameObject;
import game.graphic.image.ImageContainer;
import game.input.KeyBoard;
import game.input.Mouse;
import game.input.MouseButton;
import game.input.MouseEvent;
import game.media.Speaker;
import game.movement.MovementParameter;

import java.util.*;

/**
 * Created by Guido on 11.05.2016.
 */
public class Game {

    private String rootPath = "D:\\DevGame\\";

    private ImageContainer imageContainer;
    private Mouse mouse;
    private KeyBoard keyBoard;
    private Speaker speaker;
    private Hashtable<String, GameObjectIdentifier> gameObjectDictionary;
    private List<Scene> loadedScenes;
    private Scene currentScene;
    //GameLoop
    private Timer timer;
    private TimerTask gameLoop;
    private long delay;

    public Game(Mouse mouse, KeyBoard keyBoard, Speaker speaker) {

        this.imageContainer = new ImageContainer();
        this.mouse = mouse;
        this.keyBoard = keyBoard;
        this.speaker = speaker;
        this.gameObjectDictionary = new GameObjectDictionaryReader(this.rootPath).read();
        this.loadedScenes = new ArrayList<>();
//        this.currentScene = new Scene(imageContainer, new Dimension(2000, 1000), new ArrayList<>());

        this.timer = new Timer(true);
        this.gameLoop = new TimerTask() {
            @Override
            public void run() {
                gameLoop();
            }
        };
        this.delay = 100;

        this.mouse.addListener(this::mouseMove);
    }

    public void start() {
        this.openScene("testscene");
        timer.scheduleAtFixedRate(gameLoop, 0, delay);
    }

    public void pause() {
        timer.cancel();
    }

    public void unpause() {
        this.gameLoop = new TimerTask() {
            @Override
            public void run() {
                gameLoop();
            }
        };
        timer.scheduleAtFixedRate(gameLoop, 0, delay);
    }

    private void gameLoop() {

        this.updateAllGameObjects();
    }

    public void mouseMove(MouseEvent event) {
        if (event.getButton().contains(MouseButton.MIDDLE)) {
            System.out.println("mitte");
        }
    }

    private void openScene(String name) {
        SceneReader reader = new SceneReader(this.rootPath, this.gameObjectDictionary, imageContainer);
        Scene newScene = reader.read(name);
        this.currentScene = newScene;
        this.loadedScenes.add(newScene);
    }

    private void updateAllGameObjects() {

        List<GameObject> gameObjects = this.currentScene.getGameObjects();
        MovementParameter movementParameter = new MovementParameter(gameObjects);
        for (GameObject gameObject : gameObjects) {
            gameObject.update(movementParameter);
        }
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public ImageContainer getImageContainer() {
        return imageContainer;
    }
}
