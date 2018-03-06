package de.charaktar.game.text;

import de.charaktar.game.gameobject.GameObject;

public class Line {

    private final int maxCharactar;

    private GameObject speaker;
    private String content;
    private int index;
    private boolean isFinished;

    public Line(GameObject gameObject, String content) {
        this.speaker = gameObject;
        this.content = content;
        this.isFinished = false;
        this.index = 0;
        this.maxCharactar = 50;
    }

    public String getSpeakerName() {
        return this.speaker.getName();
    }

    public String getNextLineContent() {
        int contextLength = this.content.length();
        int end = this.index + this.maxCharactar;
        if (end > contextLength) {
            end = contextLength;
        }
        String nextText = this.content.substring(this.index, end);
//        this.index += end;
        if (this.index == contextLength) {
            this.isFinished = true;
        }
        return this.content;
    }

    public boolean isFinished() {
        return isFinished;
    }

}
