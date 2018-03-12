package de.charaktar.pointyandclicky;

import de.charaktar.ge.Bootstrapper;
import de.charaktar.ge.Game;

public class SwingEntry {

    public static void main(String[] args) {

        Bootstrapper bootstrapper = new Bootstrapper(args) {
            @Override
            protected Game createGameClass() {
                return new PointyAndClicky(this.io);
            }
        };
        bootstrapper.start();
    }

}
