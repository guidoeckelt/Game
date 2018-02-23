package game;

import game.gameobject.GameObject;
import game.input.MouseEvent;
import game.input.MouseListener;

public class HoverListener implements MouseListener {

    private Game game;
    private GameObject hoveredGameObject;

    public HoverListener(Game game) {

        this.game = game;
    }

    @Override
    public void update(MouseEvent event) {

        if (this.hoveredGameObject != null && !this.isMouseOver(event, this.hoveredGameObject)) {
            this.hoveredGameObject = null;
        }
        for (GameObject gameObject : game.getCurrentScene().getGameObjects()) {
            if (this.isMouseOver(event, gameObject)) {
                this.hoveredGameObject = gameObject;
                break;
            }
        }
//        if(this.hoveredGameObject != null){
//            System.out.println(this.hoveredGameObject.getName());
//        }
    }

    public GameObject getHoveredGameObject() {
        return hoveredGameObject;
    }

    private boolean isMouseOver(MouseEvent event, GameObject gameObject) {

        boolean xAxis = false, yAxis = false;
        if (event.getPosition().getX() > gameObject.getPosition().getX()) {
            if (event.getPosition().getX() < gameObject.getPosition().getX() + gameObject.getSize().getWidth()) {
                xAxis = true;
            }
        }
        if (event.getPosition().getY() > gameObject.getPosition().getY()) {
            if (event.getPosition().getY() < gameObject.getPosition().getY() + gameObject.getSize().getHeight()) {
                yAxis = true;
            }
        }
        return xAxis && yAxis;
    }

}
