import processing.core.PApplet;

/**
 * The CircleSapien class models the behaviors of every homo sapien like circle
 */
public class CircleSapien {
    private PApplet sketch;
    private int color;
    private int x, y;
    private int diameter;

    /**
     * Constructor takes the PApplet object and a position x and y
     * 
     * @param sketch
     * @param x
     * @param y
     */
    public CircleSapien(PApplet sketch, int x, int y) {
        this.sketch = sketch;
        // size
        this.diameter = (int) this.sketch.random(10, 40);
        // position
        this.x = x;
        this.y = y;
        // color
        this.color = this.sketch.color(255);
        this.sketch.fill(color);
        this.sketch.noStroke();
    }

    /**
     * set x position
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set y position
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * get the x position
     * 
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * get the y position
     * 
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * get the diameter of the circle
     * 
     * @return diameter
     */
    public int getDiameter() {
        return this.diameter;
    }

    /**
     * move the object, use the MotionHelper class to control the left/right/up/down
     * motion
     */
    public void move() {
        int randNum = (int) sketch.random(0, 100);
        // setX(Motion.randomVibrateHorizontal(randNum, x, 50));

        // move up
        if (y - diameter / 2 < 0) {
            setY(Motion.randomMoveDown(randNum, y, 100));
        } else
            setY(Motion.randomMoveUp(randNum, y, 66));

        // move down
        // if (y + diameter / 2 > sketch.height) {
        // setY(Motion.randomMoveUp(randNum, y, 100));
        // } else
        // setY(Motion.randomMoveDown(randNum, y, 66));
    }

    /**
     * draw on PApplet canvas
     */
    public void draw() {
        sketch.circle(x, y, diameter);
    }

    /**
     * didCollide returns true when the distance between the two edges of the
     * compared circles is 0;
     * 
     * @param c CircleSapien object to check for a collision
     * @return
     */
    public boolean isCollision(CircleSapien c) {
        // distance formula
        double dist = Math.sqrt(Math.pow((c.getX() - x), 2) + Math.pow((c.getY() - y), 2));
        // subtract radii
        double distFromEdge = dist - (diameter / 2) - (c.getDiameter() / 2);
        // check when distance to edges is 0
        if (distFromEdge == 0) {
            return true;
        } else
            return false;
    }

    /**
     * Takes a CircleSapien object and compares sizes
     * 
     * @param c CircleSapien
     * @return true if the object is larger than the one passed in
     */
    public boolean isLarger(CircleSapien c) {
        if (diameter > c.getDiameter()) {
            return true;
        } else {
            return false;
        }
    }
}
