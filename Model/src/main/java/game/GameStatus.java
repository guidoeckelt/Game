package game;

import game.gameobject.GameObject;
import game.graphic.Graphic;
import game.text.Conversation;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {

    private final GameStatusType type;
    private GameObject hoveredGameObject;
    private List<Graphic> graphics;
    private Scene activeScene;
    private Conversation activeConversation;

    public GameStatus(GameStatusType type, List<Graphic> graphics) {
        this.type = type;
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
        return this.graphics;
    }

    public GameObject getHoveredGameObject() {
        return hoveredGameObject;
    }

    public GameStatusType getType() {
        return this.type;
    }

}
