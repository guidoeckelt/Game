package de.charaktar.ge;

import de.charaktar.ge.graphic.DrawParameters;
import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.metric.Vector;

import java.awt.*;

public class DefaultGameRenderLoop extends RenderLoop {

    private Game activeGame;


    public DefaultGameRenderLoop(de.charaktar.ge.Canvas canvas, Camera camera, Game game) {
        super(canvas, camera, 10);

        this.activeGame = game;

    }

    @Override
    protected void loop() {
        if (this.activeGame != null) {
            this.drawGame(this.activeGame.currentStatus());
        } else {
            this.drawMenu();
        }
    }

    private void drawMenu() {

    }

    private void drawGame(GameStatus gameStatus) {

        GraphicContext context = this.canvas.newGraphicContext(this.currentCamera);
        if (gameStatus.getType().equals(GameStatusType.LOADING)) {
            this.drawLoadingUi(context);
        } else if (gameStatus.getType().equals(GameStatusType.RUNNING)) {
            this.drawGameBackground(context);
            this.drawGameGraphics(context, gameStatus);
            this.lastImage = context.show();
        } else if (gameStatus.getType().equals(GameStatusType.PAUSE)) {
            this.drawGamePauseUi(context);
            context.show();
        }
    }

    private void drawLoadingUi(GraphicContext context) {

        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AAAAAA", null);
        context.drawText("Loading", new Vector(700, 500), new Font("Arial", Font.BOLD, 100), "#FFFFFF", 5);
    }

    private void drawGameGraphics(GraphicContext context, GameStatus status) {

        DrawParameters drawParameters = new DrawParameters(context, status.getHoveredGameObject());
        for (Graphic graphic : status.getGraphics()) {
            graphic.draw(drawParameters);
        }
    }

    private void drawGamePauseUi(GraphicContext context) {

        if (this.lastImage != null) {
            context.drawImage(this.lastImage, new Vector(0, 0));
        }
        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AA000000", null);
        context.drawText("Pause", new Vector(700, 500), new Font("Arial", Font.BOLD, 100), "#FFFFFF", 5);
    }

    private void drawGameBackground(GraphicContext context) {

        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AAAAAA", null);
    }

}
