import processing.core.PApplet;

/**
 * Sketch class implements methods from processing applet class
 */
public class Sketch extends PApplet {
    private int WINDOW_X = 600;
    private int WINDOW_Y = 600;
    private int BACKGROUND_COLOR = 100;
    private boolean TEST_MODE;
    SimController simController;
    TestController testController;

    /**
     * settings from PApplet
     */
    @Override
    public void settings() {
        size(WINDOW_X, WINDOW_Y);
        setTestMode(true);
    }

    /**
     * setup from PApplet
     */
    @Override
    public void setup() {
        background(BACKGROUND_COLOR);
        if (TEST_MODE) {
            System.out.println("**TEST MODE IS ACTIVE**");
            testController = new TestController(this);
            testController.createTestSample();
        } else {
            simController = new SimController(this);
            simController.createSample(400, 50); // pop size, percentage zombies
        }
    }

    /**
     * draw from PApplet
     */
    @Override
    public void draw() {
        background(BACKGROUND_COLOR);
        if (TEST_MODE) {
            testController.testSimulation();
        } else {
            simController.simulate();
        }
    }

    /**
     * control the mode
     * 
     * @return true for test mode active
     */
    public boolean getTestMode() {
        return this.TEST_MODE;
    }

    /**
     * control the mode
     * 
     * @param TEST_MODE
     */
    public void setTestMode(boolean TEST_MODE) {
        this.TEST_MODE = TEST_MODE;
    }
}
