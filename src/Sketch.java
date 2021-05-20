import processing.core.PApplet;

public class Sketch extends PApplet {
    private int WINDOW_X = 600;
    private int WINDOW_Y = 600;
    private int BACKGROUND_COLOR = 100;

    @Override
    public void settings() {
        size(WINDOW_X, WINDOW_Y);
    }

    @Override
    public void setup() {
        background(BACKGROUND_COLOR);
    }
}
