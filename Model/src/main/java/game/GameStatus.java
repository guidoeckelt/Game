package game;

import game.graphic.Graphic;

import java.util.List;

public class GameStatus {

    private final List<Graphic> graphics;

    public GameStatus(List<Graphic> graphics) {
        this.graphics = graphics;
    }

    public List<Graphic> getGraphics() {
        return graphics;
    }
}
