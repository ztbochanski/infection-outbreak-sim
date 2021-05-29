import processing.core.PApplet;

/**
 * Sketch class implements methods from processing applet class
 */
public class Sketch extends PApplet {
    private int WINDOW_X = 600;
    private int WINDOW_Y = 600;
    private int BACKGROUND_COLOR = 100;
    CircleSapien zombie;
    CircleSapien human;

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
        zombie = new Zombie(this, 100, 100);
        human = new Human(this, 100, 150);
    }

    /**
     * draw from PApplet
     */
    @Override
    public void draw() {
        background(BACKGROUND_COLOR);
        zombie.draw();
        zombie.move();
        human.draw();
        human.move();

    }
}
