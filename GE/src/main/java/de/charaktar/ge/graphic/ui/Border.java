package de.charaktar.ge.graphic.ui;

public class Border {

    private String color;
    private int width;

    public Border(String color) {

        this(color, 2);
    }

    public Border(String color, int width) {
        this.color = color;
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

}
