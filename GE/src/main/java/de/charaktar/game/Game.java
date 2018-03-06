package de.charaktar.game;

import de.charaktar.game.filesystem.GameObjectFactoryDictionaryReader;
import de.charaktar.game.gameobject.GameObjectFactory;
import de.charaktar.game.graphic.Graphic;
import de.charaktar.game.graphic.image.ImageContainer;
import de.charaktar.game.input.KeyBoard;
import de.charaktar.game.input.Mouse;
import de.charaktar.game.media.Speaker;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Guido on 11.05.2016.
 */
public abstract class Game {

    protected String rootPath = "D:\\DevGame\\";

    protected Mouse mouse;
    protected KeyBoard keyBoard;
    protected Speaker speaker;
    protected ImageContainer imageContainer;
    protected Hashtable<String, GameObjectFactory> gameObjectFactoryDictionary;
    protected List<Graphic> ui;
    protected GameLoop gameLoop;
    protected boolean isLoading = true;

    public Game(Mouse mouse, KeyBoard keyBoard, Speaker speaker) {

        this.mouse = mouse;
        this.keyBoard = keyBoard;
        this.speaker = speaker;
        this.imageContainer = new ImageContainer();
        this.gameObjectFactoryDictionary = new GameObjectFactoryDictionaryReader(this.rootPath).read();
        this.gameLoop = new GameLoop(this);
        this.ui = new ArrayList<>();
    }

    public void start() {

        this.OnStartUp();
        this.isLoading = false;
        this.gameLoop.start();
    }

    public void toggle() {
        if (isLoading) {
            return;
        }
        if (this.gameLoop.isRunning()) {
            this.gameLoop.pause();
        } else {
            this.gameLoop.unpause();
        }
    }

    protected abstract void OnStartUp();

    public abstract GameStatus currentStatus();


    public ImageContainer getImageContainer() {
        return imageContainer;
    }

}
