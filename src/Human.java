import processing.core.PApplet;

/**
 * The Human class models the behaviors of human specific circle
 */
public class Human extends CircleSapien {
    PApplet sketch;
    private int color;

    /**
     * Constructor takes the PApplet object and a position x and y
     * 
     * @param sketch
     * @param x
     * @param y
     */
    public Human(PApplet sketch, int x, int y) {
        super(sketch, x, y);
        this.sketch = sketch;
        this.color = new Color(this.sketch).randomCoolColor();
    }

    /**
     * draw human on PApplet canvas
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
        // move up
        if (super.getY() - super.getDiameter() / 2 < 0) {
            setY(Motion.randomMoveDown(randNum, super.getY(), 100));
        } else
            setY(Motion.randomMoveUp(randNum, super.getY(), 66));
    }

    /**
     * test movement for constant movement
     */
    public void testMove() {
        // move up
        if (super.getY() - super.getDiameter() / 2 < 0) {
            setY(Motion.constantMoveDown(super.getY()));
        } else
            setY(Motion.constantMoveUp(super.getY()));
    }

}
