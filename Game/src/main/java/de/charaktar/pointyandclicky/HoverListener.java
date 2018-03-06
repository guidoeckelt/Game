package de.charaktar.pointyandclicky;

import de.charaktar.game.Game;
import de.charaktar.game.GameStatus;
import de.charaktar.game.gameobject.GameObject;
import de.charaktar.game.input.MouseEvent;
import de.charaktar.game.input.MouseListener;

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
        GameStatus status = this.game.currentStatus();
        for (GameObject gameObject : status.getGameObjects()) {
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
