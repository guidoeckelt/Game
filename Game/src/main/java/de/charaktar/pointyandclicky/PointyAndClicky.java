package de.charaktar.pointyandclicky;

import de.charaktar.ge.Game;
import de.charaktar.ge.GameStatus;
import de.charaktar.ge.GameStatusType;
import de.charaktar.ge.Scene;
import de.charaktar.ge.filesystem.SceneReader;
import de.charaktar.ge.graphic.text.Dialog;
import de.charaktar.ge.graphic.text.Line;
import de.charaktar.ge.graphic.ui.Button;
import de.charaktar.ge.inputoutput.InputOutputDevices;
import de.charaktar.ge.inputoutput.KeyBoardButton;
import de.charaktar.ge.metric.Dimension;
import de.charaktar.ge.metric.Vector;
import de.charaktar.pointyandclicky.inputoutput.HoverListener;

import java.util.ArrayList;
import java.util.List;

public class PointyAndClicky extends Game {

    private List<Scene> loadedScenes;
    private Scene currentScene;
    private HoverListener hoverListener;
    private List<Dialog> loadedConversations;
    private Dialog currentConversation;

    public PointyAndClicky(InputOutputDevices io) {

        super(io);
        this.loadedScenes = new ArrayList<>();
        this.hoverListener = new HoverListener(this);
        this.loadedConversations = new ArrayList<>();
    }

    @Override
    protected void OnStartUp() {

        this.ui = new ArrayList<>();
        Button button = new Button("Exit", null, new Vector(700, 250), new Dimension(520, 100));
        this.ui.add(button);
        this.openScene("testscene");
        this.io.getMouse().addListener(this.hoverListener);
        this.io.getKeyBoard().addListener(kbe -> {
            if (kbe.getReleasedButton().equals(KeyBoardButton.ESCAPE)) {
                this.toggle();
            }
        });
        this.playConversation();
    }

    @Override
    public GameStatus currentStatus() {

        if (this.isLoading) {
            return new GameStatus(GameStatusType.LOADING, new ArrayList<>(), this.ui);
        }
        if (this.gameLoop.isRunning()) {
            return new GameStatus(this.currentScene, this.hoverListener.getHoveredGameObject(), this.currentConversation);
        } else {
            return new GameStatus(GameStatusType.PAUSE, this.currentScene.getGameObjects(), this.ui);
        }
    }

    private void openScene(String name) {

        SceneReader reader = new SceneReader(this.rootPath, this.gameObjectFactoryDictionary, this.imageContainer);
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
        Dialog conversation = new Dialog(lines);
        this.currentConversation = conversation;
        this.loadedConversations.add(conversation);
    }


}
