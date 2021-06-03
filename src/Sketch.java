import processing.core.PApplet;

/**
 * Sketch class implements methods from processing applet class
 */
public class Sketch extends PApplet {
    private int WINDOW_X;
    private int WINDOW_Y;
    private int BACKGROUND_COLOR = 100;
    private boolean TEST_MODE;
    SimController simController;
    TestController testController;

    /**
     * settings from PApplet
     */
    @Override
    public void settings() {
        setTestMode(true);
        if (TEST_MODE) {
            setWindowSize(600, 600);
        } else {
            setWindowSize(1000, 600);
        }
        size(WINDOW_X, WINDOW_Y);
    }

    /**
     * setup from PApplet
     */
    @Override
    public void setup() {
        background(BACKGROUND_COLOR);
        if (TEST_MODE) {
            System.out.println("**TEST MODE IS ACTIVE**");
            frameRate(4);
            testController = new TestController(this);
            testController.createTestSample();
        } else {
            simController = new SimController(this);
            simController.createSample(400, 50); // (pop size, percentage infected)
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
            // testController.runModel(25, 50, 25); // (death rate, incubation rate,
            // resistance rate)
        } else {
            simController.simulate();
        }
    }

    /**
     * control the mode
     * 
     * @param TEST_MODE
     */
    public void setTestMode(boolean TEST_MODE) {
        this.TEST_MODE = TEST_MODE;
    }

    /**
     * set window size in sketch
     * 
     * @param WINDOW_X
     * @param WINDOW_Y
     */
    public void setWindowSize(int WINDOW_X, int WINDOW_Y) {
        this.WINDOW_X = WINDOW_X;
        this.WINDOW_Y = WINDOW_Y;
    }
}
