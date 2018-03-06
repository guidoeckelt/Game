package de.charaktar.game;

import de.charaktar.game.gameobject.GameObject;
import de.charaktar.game.graphic.Graphic;
import de.charaktar.game.text.Conversation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameStatus {

    private final GameStatusType type;
    private List<GameObject> gameObjects;
    private List<Graphic> graphics;
    private GameObject hoveredGameObject;
    private Scene activeScene;
    private Conversation activeConversation;

    public GameStatus(GameStatusType type, List<GameObject> gameObjects, List<Graphic> graphics) {

        this.type = type;
        this.gameObjects = gameObjects;
        this.graphics = graphics;
    }

    public GameStatus(Scene scene, GameObject hoveredGameObject, Conversation conversation) {

        this.graphics = new ArrayList<>();
        this.activeScene = scene;
        this.activeConversation = conversation;
        this.hoveredGameObject = hoveredGameObject;
        this.getFromRunningGame();
        this.type = GameStatusType.RUNNING;
    }

    private void getFromRunningGame() {

        if (this.activeConversation != null) {
            this.graphics.add(this.activeConversation.getGraphic());
        }
        if (this.activeScene != null) {
            List<GameObject> allGameObjects = this.activeScene.getGameObjects();
            for (GameObject gameObject : allGameObjects) {
                this.graphics.add(gameObject.currentGraphic());
            }
        }
    }

    public List<Graphic> getGraphics() {
        return Collections.unmodifiableList(this.graphics);
    }

    public List<GameObject> getGameObjects() {
        return Collections.unmodifiableList(this.activeScene.getGameObjects());
    }

    public GameObject getHoveredGameObject() {
        return hoveredGameObject;
    }

    public GameStatusType getType() {
        return this.type;
    }

}
