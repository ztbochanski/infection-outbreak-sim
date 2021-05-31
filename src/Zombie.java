import processing.core.PApplet;

/**
 * The Zombie class models the behaviors of zombie specific circle
 */
public class Zombie extends CircleSapien {
    PApplet sketch;
    private int color;

    /**
     * Constructor takes the PApplet object and a position x and y
     * 
     * @param sketch
     * @param x
     * @param y
     */
    public Zombie(PApplet sketch, int x, int y) {
        super(sketch, x, y);
        this.sketch = sketch;
        this.color = new Color(this.sketch).randomWarmColor();
    }

    /**
     * draw zombie on PApplet canvas
     */
    @Override
    public void draw() {
        this.sketch.fill(color);
        this.sketch.noStroke();
        sketch.circle(super.getX(), super.getY(), super.getDiameter());
    }

    /**
     * move the object, use the MotionHelper class to control the left/right/up/down
     * motion
     */
    @Override
    public void move() {
        int randNum = (int) sketch.random(0, 100);
        setX(Motion.randomVibrateHorizontal(randNum, super.getX(), 50));
        // move down
        if (super.getY() + super.getDiameter() / 2 > sketch.height) {
            setY(Motion.randomMoveUp(randNum, super.getY(), 100));
        } else
            setY(Motion.randomMoveDown(randNum, super.getY(), 66));
    }

    /**
     * test movement for constant movement
     */
    public void testMove() {
        // move down
        if (super.getY() + super.getDiameter() / 2 > sketch.height) {
            setY(Motion.constantMoveUp(super.getY()));
        } else
            setY(Motion.constantMoveDown(super.getY()));
    }

    /**
     * kill behavior
     */
    @Override
    public void kill() {
        // make sound
    }

    /**
     * convert behavior
     */
    @Override
    public void convert() {
        // change object
    }
}
