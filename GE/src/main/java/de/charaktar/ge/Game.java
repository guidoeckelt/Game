package de.charaktar.ge;

import de.charaktar.ge.filesystem.GameObjectFactoryDictionaryReader;
import de.charaktar.ge.gameobject.GameObjectFactory;
import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.image.ImageContainer;
import de.charaktar.ge.input.KeyBoard;
import de.charaktar.ge.input.Mouse;
import de.charaktar.ge.media.Speaker;

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
