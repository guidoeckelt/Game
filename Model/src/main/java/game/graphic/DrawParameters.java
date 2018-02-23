package game.graphic;


import game.gameobject.GameObject;

/**
 * Created by Guido on 14.05.2016.
 */
public class DrawParameters {

    private final GraphicContext context;
    private GameObject hoveredGameObject;

    public DrawParameters(GraphicContext context, GameObject hoveredGameObject) {

        this.context = context;
        this.hoveredGameObject = hoveredGameObject;
    }

    public GraphicContext getContext() {
        return context;
    }

    public boolean isHovered(GameObject gameObject) {

        if (this.hoveredGameObject == null) {
            return false;
        }
        return this.hoveredGameObject.equals(gameObject);
    }

}
