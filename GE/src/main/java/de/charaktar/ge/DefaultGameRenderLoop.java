package de.charaktar.ge;

import de.charaktar.ge.graphic.Graphic;
import de.charaktar.ge.graphic.GraphicContext;
import de.charaktar.ge.graphic.image.Image;
import de.charaktar.ge.metric.Vector;

import java.awt.*;

public class DefaultGameRenderLoop implements RenderLoop {

    private Canvas canvas;
    private Camera camera;
    private Game activeGame;
    private Image lastGameImage;


    public DefaultGameRenderLoop(de.charaktar.ge.Canvas canvas, Game game) {

        this.canvas = canvas;
        this.camera = new Camera(new Vector(0, 0), this.canvas.getViewport());
        this.activeGame = game;

    }

    @Override
    public Image tick() {
        GameStatus gameStatus = this.activeGame.currentStatus();
        return this.drawGame(gameStatus);
    }

    private Image drawGame(GameStatus gameStatus) {

        DrawingContext context = this.canvas.newDrawingContext(this.camera);
        if (gameStatus.getType().equals(GameStatusType.LOADING)) {
            this.drawLoadingUi(context);
        } else if (gameStatus.getType().equals(GameStatusType.RUNNING)) {
            this.drawGameGraphics(context, gameStatus);
            this.lastGameImage = context.end();
            return this.lastGameImage;
        } else if (gameStatus.getType().equals(GameStatusType.PAUSE)) {
            this.drawGamePauseUi(context, gameStatus);
        }
        return context.end();
    }

    private void drawLoadingUi(DrawingContext context) {

        context.fillRect(new Vector(0, 0), this.canvas.getViewport(), "#AAAAAA");
        Font font = new Font("Arial", Font.BOLD, 100);
        context.fillText("Loading", new Vector(700, 500), font, "#FFFFFF");
        context.strokeText("Loading", new Vector(700, 500), font, "#000000", 5);
    }

    private void drawGameGraphics(DrawingContext context, GameStatus status) {
        this.drawGameBackground(context);
        for (Graphic graphic : status.getGraphics()) {
            graphic.draw(context);
        }
    }

    private void drawGamePauseUi(DrawingContext context, GameStatus gameStatus) {

        if (this.lastGameImage != null) {
            context.drawImage(this.lastGameImage, new Vector(0, 0));
        }
        context.fillRect(new Vector(0, 0), this.canvas.getViewport(), "#AA000000");
        Font font = new Font("Arial", Font.BOLD, 120);
        context.fillText("Pause", new Vector(700, 150), font, "#FFFFFF");
        context.strokeText("Pause", new Vector(700, 150), font, "#000000", 5);
        for (Graphic graphic : gameStatus.getUi()) {
            graphic.draw(context);
        }
    }

    private void drawGameBackground(GraphicContext context) {

        context.fillRect(new Vector(0, 0), this.canvas.getViewport(), "#AAAAAA");
    }

}
