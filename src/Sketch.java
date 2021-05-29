import processing.core.PApplet;

/**
 * Sketch class implements methods from processing applet class
 */
public class Sketch extends PApplet {
    private int WINDOW_X = 600;
    private int WINDOW_Y = 600;
    private int BACKGROUND_COLOR = 100;
    Simulator simulator;

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
        simulator = new Simulator(this);
    }

    /**
     * draw from PApplet
     */
    @Override
    public void draw() {
        background(BACKGROUND_COLOR);
        for (int i = 0; i < simulator.circleSapienSystem.getSize() - 1; i++) {
            simulator.circleSapienSystem.getSapien(i).draw();
            simulator.circleSapienSystem.getSapien(i).move();

        }
    }
}
