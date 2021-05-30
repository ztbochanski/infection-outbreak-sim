import processing.core.PApplet;

/**
 * Sketch class implements methods from processing applet class
 */
public class Sketch extends PApplet {
    private int WINDOW_X = 600;
    private int WINDOW_Y = 600;
    private int BACKGROUND_COLOR = 100;
    SimController simController;
    TestController testController;

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
        simController = new SimController(this);
        testController = new TestController(this);
        // simController.createSample(100, 25); // pop size, percentage zombies
        testController.createTestSample();
    }

    /**
     * draw from PApplet
     */
    @Override
    public void draw() {
        background(BACKGROUND_COLOR);
        // simController.simulateMovement();
        testController.testSimulation();
    }
}
