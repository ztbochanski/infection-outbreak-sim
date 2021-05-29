import processing.core.PApplet;

/**
 * The CircleSapien class models the behaviors of every homo sapien like circle
 */
public abstract class CircleSapien {
    private PApplet sketch;
    private int x, y;
    private final int diameter;

    /**
     * Constructor takes the PApplet object and a position x and y
     * 
     * @param sketch
     * @param x
     * @param y
     */
    public CircleSapien(PApplet sketch, int x, int y) {
        this.sketch = sketch;
        this.diameter = (int) this.sketch.random(10, 40);
        this.x = x;
        this.y = y;
    }

    /**
     * draw on PApplet canvas
     */
    public abstract void draw();

    /**
     * abstract, each child must implement their own movements
     */
    public abstract void move();

    /**
     * destroy the other object
     */
    public abstract void kill(CircleSapien c);

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
        // check when distance to edges is 0 or less
        if (distFromEdge <= 0) {
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
