package game;

import game.filesystem.GameObjectFactoryDictionaryReader;
import game.filesystem.SceneReader;
import game.gameobject.GameObjectFactory;
import game.graphic.Graphic;
import game.graphic.image.ImageContainer;
import game.input.KeyBoard;
import game.input.KeyBoardButton;
import game.input.Mouse;
import game.media.Speaker;
import game.text.Conversation;
import game.text.Line;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Guido on 11.05.2016.
 */
public class Game {

    private String rootPath = "D:\\DevGame\\";

    private Mouse mouse;
    private KeyBoard keyBoard;
    private Speaker speaker;
    private ImageContainer imageContainer;
    private GameLoop gameLoop;
    private Hashtable<String, GameObjectFactory> gameObjectFactoryDictionary;
    private List<Scene> loadedScenes;
    private Scene currentScene;
    private HoverListener hoverListener;
    private List<Conversation> loadedConversations;
    private Conversation currentConversation;
    private List<Graphic> ui;

    public Game(Mouse mouse, KeyBoard keyBoard, Speaker speaker) {

        this.mouse = mouse;
        this.keyBoard = keyBoard;
        this.speaker = speaker;
        this.imageContainer = new ImageContainer();
        this.gameLoop = new GameLoop(this);
        this.gameObjectFactoryDictionary = new GameObjectFactoryDictionaryReader(this.rootPath).read();
        this.loadedScenes = new ArrayList<>();
        this.hoverListener = new HoverListener(this);
        this.loadedConversations = new ArrayList<>();
        this.ui = new ArrayList<>();
    }

    public void start() {

        this.openScene("testscene");
        this.mouse.addListener(this.hoverListener);
        this.keyBoard.addListener(kbe -> {
            if (kbe.getReleasedButton().equals(KeyBoardButton.ESCAPE)) {
                this.toggle();
            }
        });
        this.gameLoop.start();
        this.playConversation();

    }

    public void toggle() {

        if (this.gameLoop.isRunning()) {
            this.gameLoop.pause();
        } else {
            this.gameLoop.unpause();
        }
    }

    private void openScene(String name) {

        SceneReader reader = new SceneReader(this.rootPath, this.gameObjectFactoryDictionary, imageContainer);
        Scene newScene = reader.read(name);
        this.currentScene = newScene;
        this.loadedScenes.add(newScene);
    }

    private void playConversation() {

        List<Line> lines = new ArrayList<>();
        Line line = new Line(currentScene.getGameObjects().get(0), "Hey, I am Pointy. Nice to meet you.");
        lines.add(line);
        Line line2 = new Line(currentScene.getGameObjects().get(1), "And I am Clicky. We are best buddys since i can think of");
        lines.add(line2);
        Conversation conversation = new Conversation(lines);
        this.currentConversation = conversation;
        this.loadedConversations.add(conversation);
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

    public GameStatus getStatus() {

        if (this.gameLoop.isRunning()) {
            return new GameStatus(this.currentScene, this.currentConversation, this.hoverListener.getHoveredGameObject());
        } else {
            return new GameStatus(GameMode.PAUSE, this.ui);
        }
    }

}
