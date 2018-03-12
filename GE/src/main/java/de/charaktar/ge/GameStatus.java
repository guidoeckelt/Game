package de.charaktar.ge;

import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.text.Dialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameStatus {

    private final GameStatusType type;
    private List<GameObject> gameObjects;
    private List<Graphic> ui;
    private GameObject hoveredGameObject;
    private Scene activeScene;
    private Dialog activeConversation;

    public GameStatus(GameStatusType type, List<GameObject> gameObjects, List<Graphic> ui) {

        this.type = type;
        this.gameObjects = gameObjects;
        this.ui = ui;
    }

    public GameStatus(Scene scene, GameObject hoveredGameObject, Dialog conversation) {

        this.type = GameStatusType.RUNNING;
        this.ui = new ArrayList<>();
        this.activeScene = scene;
        this.activeConversation = conversation;
        this.hoveredGameObject = hoveredGameObject;
    }

    public GameStatusType getType() {
        return this.type;
    }

    public List<GameObject> getGameObjects() {
        if (this.activeScene == null) {
            return Collections.unmodifiableList(this.gameObjects);
        }
        return Collections.unmodifiableList(this.activeScene.getGameObjects());
    }

    public List<Graphic> getGraphics() {
        List<Graphic> graphics = new ArrayList<>();
        if (this.activeConversation != null) {
            graphics.add(this.activeConversation.getGraphic());
        }
        if (this.activeScene != null) {
            List<GameObject> allGameObjects = this.activeScene.getGameObjects();
            for (GameObject gameObject : allGameObjects) {
                graphics.add(gameObject.currentGraphic());
            }
        }
        return graphics;
    }

    public List<Graphic> getUi() {
        return ui;
    }

    public GameObject getHoveredGameObject() {
        return hoveredGameObject;
    }


}
