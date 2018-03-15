package de.charaktar.ge.inputoutput;

public class InputOutputDevices {

    private final Mouse mouse;
    private final KeyBoard keyBoard;
    private final Speaker speaker;

    public InputOutputDevices(Mouse mouse, KeyBoard keyBoard, Speaker speaker) {

        this.mouse = mouse;
        this.keyBoard = keyBoard;
        this.speaker = speaker;
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
