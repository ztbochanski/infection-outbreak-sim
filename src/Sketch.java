import processing.core.PApplet;

/**
 * Sketch class implements methods from processing applet class
 */
public class Sketch extends PApplet {
    private int windowX;
    private int windowY;
    private int BACKGROUND_COLOR = 100;
    private boolean testMode;
    SimController simController;
    TestController testController;

    /**
     * settings from PApplet
     */
    @Override
    public void settings() {
        setTestMode(true);
        if (testMode) {
            setWindowSize(600, 600);
        } else {
            setWindowSize(1000, 600);
        }
        size(windowX, windowY);
    }

    /**
     * setup from PApplet
     */
    @Override
    public void setup() {
        background(BACKGROUND_COLOR);
        if (testMode) {
            System.out.println("**TEST MODE IS ACTIVE**");
            // frameRate(5);
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
        if (testMode) {
            testController.testSimulation();
        } else {
            simController.simulate();
        }
    }

    /**
     * control the mode
     * 
     * @param testMode
     */
    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    /**
     * set window size in sketch
     * 
     * @param windowX
     * @param windowY
     */
    public void setWindowSize(int windowX, int windowY) {
        this.windowX = windowX;
        this.windowY = windowY;
    }
}
