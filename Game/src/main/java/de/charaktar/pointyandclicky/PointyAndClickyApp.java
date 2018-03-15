package de.charaktar.pointyandclicky;

import de.charaktar.ge.GEApplication;
import de.charaktar.ge.Game;
import de.charaktar.ge.View;

public class PointyAndClickyApp extends GEApplication {

    public static void main(String[] args) {

        PointyAndClickyApp app = new PointyAndClickyApp(args);
        View view = app.start();
//        Game game = app.createGameClass();
//        view.render(game);
//        game.start();
    }

    public PointyAndClickyApp(String[] args) {
        super(args);
    }

    @Override
    public Game createGameClass() {

        return new PointyAndClicky(this.io);
    }

}
