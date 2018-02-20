package game;

import game.filesystem.GameObjectDictionaryReader;
import game.filesystem.SceneReader;
import game.graphic.image.ImageContainer;
import game.input.KeyBoard;
import game.input.Mouse;
import game.input.MouseEvent;
import game.media.Speaker;
import game.text.Conversation;
import game.text.Line;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Timer;

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
    private long delay;

    public Game(Mouse mouse, KeyBoard keyBoard, Speaker speaker) {

        this.imageContainer = new ImageContainer();
        this.mouse = mouse;
        this.keyBoard = keyBoard;
        this.speaker = speaker;
        this.gameObjectDictionary = new GameObjectDictionaryReader(this.rootPath).read();
        this.loadedScenes = new ArrayList<>();
        this.timer = new Timer(true);
        this.delay = 100;
        this.mouse.addListener(this::mouseMove);
    }

    public void start() {

        this.openScene("testscene");
        timer.scheduleAtFixedRate(new GameLoop(this), 0, delay);
    }

    public void pause() {

        timer.cancel();
    }

    public void unpause() {

        timer.scheduleAtFixedRate(new GameLoop(this), 0, delay);
    }

    public void mouseMove(MouseEvent event) {

    }

    private void openScene(String name) {

        SceneReader reader = new SceneReader(this.rootPath, this.gameObjectDictionary, imageContainer);
        Scene newScene = reader.read(name);
        this.currentScene = newScene;
        this.loadedScenes.add(newScene);
    }

    private void playConversation() {

        Line line = new Line(currentScene.getGameObjects().get(0), "Hey, I am Pointy. Nice to meet you.");
        List<Line> lines = new ArrayList<>();
        lines.add(line);
        Conversation conversation = new Conversation(lines);
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
