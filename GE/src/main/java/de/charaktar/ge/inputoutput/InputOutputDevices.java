package de.charaktar.ge.inputoutput;

public class InputOutputDevices {

    private final Speaker speaker;
    private final Mouse mouse;
    private final KeyBoard keyBoard;

    public InputOutputDevices(Speaker speaker, Mouse mouse, KeyBoard keyBoard) {

        this.speaker = speaker;
        this.mouse = mouse;
        this.keyBoard = keyBoard;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

}
