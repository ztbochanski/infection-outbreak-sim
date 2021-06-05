import java.util.ArrayList;
import processing.core.PApplet;

/**
 * The Sapien class models the behaviors of every homo sapien like circle
 */
public abstract class Sapien {
    private PApplet sketch;
    private ParticleSystem p;
    private Sapien contactWith;
    private int x, y;
    private int diameter;
    private int color;

    /**
     * Constructor takes the PApplet object and a position x and y
     * 
     * @param sketch
     * @param x
     * @param y
     */
    public Sapien(PApplet sketch, int x, int y) {
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.diameter = (int) this.sketch.random(10, 40);
        this.color = 0;

    }

    /**
     * Constructor takes the PApplet object and a position x and y
     * 
     * @param sketch
     * @param x
     * @param y
     */
    public Sapien(PApplet sketch, int x, int y, int diameter) {
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = 0;

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
     * test movement for constant movement
     */
    public abstract void testMove();

    /**
     * set x position
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
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
     * set y position
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
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
     * set the diameter
     * 
     * @param diameter
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    /**
     * get the diameter
     * 
     * @return diameter
     */
    public int getDiameter() {
        return this.diameter;
    }

    /**
     * set the color
     * 
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * get the color
     * 
     * @param color
     * @return
     */
    public int getColor(int color) {
        return this.color;
    }

    /**
     * check to see if object are touching using the distance formula
     * 
     * @param c the other object
     * @return
     */
    public boolean isTouching(Sapien s) {
        return (PApplet.dist(this.x, this.y, s.getX(), s.getY()) < ((this.diameter / 2) + (s.getDiameter() / 2)));
    }

    /**
     * Takes a Sapien object and compares sizes
     * 
     * @return true if the object is larger
     */
    public boolean isLarger(Sapien s) {
        return (this.diameter >= s.getDiameter());
    }

    /**
     * is winning takes integer as prob to return t/f
     * 
     * @param probability
     * @return
     */
    public boolean isWinning(int probability) {
        int randNum = (int) sketch.random(0, 100);
        return (randNum < probability);
    }

    /**
     * is infected determines the prob of the infection
     * 
     * @param probability
     * @return
     */
    public boolean isInfected(int probability) {
        int randNum = (int) sketch.random(0, 100);
        return (randNum < probability);
    }
}
