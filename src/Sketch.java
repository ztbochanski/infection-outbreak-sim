import processing.core.PApplet;

public class Sketch extends PApplet {
    private int WINDOW_X = 600;
    private int WINDOW_Y = 600;
    private int BACKGROUND_COLOR = 100;
    CircleSapien circleSapien;

    @Override
    public void settings() {
        size(WINDOW_X, WINDOW_Y);
    }

    @Override
    public void setup() {
        background(BACKGROUND_COLOR);
        circleSapien = new CircleSapien(this, new Color(this).warmColor(), (int) random(20, 60), 100, 100);
    }

    @Override
    public void draw() {
        background(BACKGROUND_COLOR);
        circleSapien.draw();
        circleSapien.move();
    }
}
