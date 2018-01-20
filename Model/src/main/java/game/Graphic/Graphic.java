package game.Graphic;

import gameobject.GameObject;
import util.DrawParameters;

public abstract class Graphic<T extends GameObject> {

    protected T gameObject;

    public Graphic(T gameObject) {
        this.gameObject = gameObject;
    }

    public abstract void draw(DrawParameters drawParameters);
}
