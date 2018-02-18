package game;

import game.gameobject.GameObject;
import game.movement.MovementParameter;

import java.util.List;
import java.util.TimerTask;

public class GameLoop extends TimerTask {

    private Game game;

    public GameLoop(Game game) {

        this.game = game;
    }

    @Override
    public void run() {

        List<GameObject> gameObjects = this.game.getCurrentScene().getGameObjects();
        MovementParameter movementParameter = new MovementParameter(gameObjects);
        for (GameObject gameObject : gameObjects) {
            gameObject.update(movementParameter);
        }
    }

}
