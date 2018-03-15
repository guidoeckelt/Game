package de.charaktar.pointyandclicky.inputoutput;

import de.charaktar.ge.Game;
import de.charaktar.ge.GameStatus;
import de.charaktar.ge.gameobject.GameObject;
import de.charaktar.ge.inputoutput.MouseEvent;
import de.charaktar.ge.inputoutput.MouseListener;

public class HoverListener implements MouseListener {

    private Game game;
    private GameObject hoveredGameObject;

    public HoverListener(Game game) {

        this.game = game;
    }

    @Override
    public void onAction(MouseEvent event) {

    }

    @Override
    public void onMove(MouseEvent event) {

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
