import processing.core.PApplet;

/**
 * Sketch class implements methods from processing applet class
 */
public class Sketch extends PApplet {
    private int WINDOW_X = 600;
    private int WINDOW_Y = 600;
    private int BACKGROUND_COLOR = 100;
    CircleSapien cs1;
    CircleSapien cs2;

    /**
     * settings from PApplet
     */
    @Override
    public void settings() {
        size(WINDOW_X, WINDOW_Y);
    }

    /**
     * setup from PApplet
     */
    @Override
    public void setup() {
        background(BACKGROUND_COLOR);
        cs1 = new CircleSapien(this, 100, 100);
        cs2 = new CircleSapien(this, 100, 200);
    }

    /**
     * draw from PApplet
     */
    @Override
    public void draw() {
        background(BACKGROUND_COLOR);
        cs1.draw();
        cs2.draw();
        cs2.move();
        cs2.isCollision(cs1);
    }
}
