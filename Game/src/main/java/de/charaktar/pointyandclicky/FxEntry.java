package de.charaktar.pointyandclicky;


import de.charaktar.fx.FxApp;
import javafx.application.Application;

public class FxEntry extends FxApp {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    protected Class gameClass() {
        return PointyAndClicky.class;
    }
}
