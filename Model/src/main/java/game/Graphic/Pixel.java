package game.Graphic;

public class Pixel {

    private int blue;
    private int alpha;
    private int red;
    private int green;

    public Pixel(int int_argb) {
        this.alpha = (int_argb >> 24) & 0xFF;
        this.red = (int_argb >> 16) & 0xFF;
        this.green = (int_argb >> 8) & 0xFF;
        this.blue = (int_argb) & 0xFF;
    }

    public Pixel(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    public int getAlpha() {
        return this.alpha;
    }


}
