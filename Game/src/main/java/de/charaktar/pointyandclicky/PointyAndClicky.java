package de.charaktar.pointyandclicky;

import de.charaktar.game.Game;
import de.charaktar.game.GameStatus;
import de.charaktar.game.GameStatusType;
import de.charaktar.game.Scene;
import de.charaktar.game.filesystem.SceneReader;
import de.charaktar.game.input.KeyBoard;
import de.charaktar.game.input.KeyBoardButton;
import de.charaktar.game.input.Mouse;
import de.charaktar.game.media.Speaker;
import de.charaktar.game.text.Conversation;
import de.charaktar.game.text.Line;

import java.util.ArrayList;
import java.util.List;

public class PointyAndClicky extends Game {

    private List<Scene> loadedScenes;
    private Scene currentScene;
    private HoverListener hoverListener;
    private List<Conversation> loadedConversations;
    private Conversation currentConversation;

    public PointyAndClicky(Mouse mouse, KeyBoard keyBoard, Speaker speaker) {

        super(mouse, keyBoard, speaker);
        this.loadedScenes = new ArrayList<>();
        this.hoverListener = new HoverListener(this);
        this.loadedConversations = new ArrayList<>();
    }

    @Override
    protected void OnStartUp() {

        this.openScene("testscene");
        this.mouse.addListener(this.hoverListener);
        this.keyBoard.addListener(kbe -> {
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
        Conversation conversation = new Conversation(lines);
        this.currentConversation = conversation;
        this.loadedConversations.add(conversation);
    }


}
