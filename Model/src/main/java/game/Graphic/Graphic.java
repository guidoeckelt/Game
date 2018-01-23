package game.Graphic;

import game.gameobject.GameObject;

public abstract class Graphic {

    protected GameObject gameObject;

    public Graphic(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public abstract void draw(DrawParameters drawParameters);
}
