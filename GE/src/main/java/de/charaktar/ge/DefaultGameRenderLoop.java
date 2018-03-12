package de.charaktar.ge;

import de.charaktar.ge.graphic.DrawParameters;
import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.metric.Vector;

import java.awt.*;

public class DefaultGameRenderLoop extends RenderLoop {

    private Camera camera;
    private Game activeGame;
    private Image lastGameImage;


    public DefaultGameRenderLoop(de.charaktar.ge.Canvas canvas, Camera camera, Game game) {
        super(canvas);

        this.camera = camera;
        this.activeGame = game;

    }

    @Override
    protected Image loop() {
        GameStatus gameStatus = this.activeGame.currentStatus();
        return this.drawGame(gameStatus);
    }

    private Image drawGame(GameStatus gameStatus) {

        GraphicContext context = this.canvas.newGraphicContext(this.camera);
        if (gameStatus.getType().equals(GameStatusType.LOADING)) {
            this.drawLoadingUi(context);
        } else if (gameStatus.getType().equals(GameStatusType.RUNNING)) {
            this.drawGameBackground(context);
            this.drawGameGraphics(context, gameStatus);
            this.lastGameImage = context.end();
            return this.lastGameImage;
        } else if (gameStatus.getType().equals(GameStatusType.PAUSE)) {
            this.drawGamePauseUi(context, gameStatus);
        }
        return context.end();
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

    private void drawGamePauseUi(GraphicContext context, GameStatus gameStatus) {

        if (this.lastGameImage != null) {
            context.drawImage(this.lastGameImage, new Vector(0, 0));
        }
        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AA000000", null);
        context.drawText("Pause", new Vector(700, 150), new Font("Arial", Font.BOLD, 120), "#FFFFFF", 5);
        DrawParameters parameters = new DrawParameters(context, null);
        for (Graphic graphic : gameStatus.getUi()) {
            graphic.draw(parameters);
        }
    }

    private void drawGameBackground(GraphicContext context) {

        context.drawRect(new Vector(0, 0), this.canvas.getViewport(), "#AAAAAA", null);
    }

}
