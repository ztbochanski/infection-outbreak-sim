import java.util.ArrayList;
import processing.core.PApplet;

/**
 * The CircleSapien class models the behaviors of every homo sapien like circle
 */
public abstract class CircleSapien {
    private PApplet sketch;
    private ParticleSystem p;
    private CircleSapien contactWith;
    private int x, y;
    private int diameter;
    private int color;
    private boolean IS_CONTACT;
    private boolean IS_DEAD;

    /**
     * Constructor takes the PApplet object and a position x and y
     * 
     * @param sketch
     * @param x
     * @param y
     */
    public CircleSapien(PApplet sketch, int x, int y) {
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.diameter = (int) this.sketch.random(10, 40);
        this.color = 0;
        this.IS_CONTACT = false;
        this.IS_DEAD = false;

    }

    /**
     * Constructor takes the PApplet object and a position x and y
     * 
     * @param sketch
     * @param x
     * @param y
     */
    public CircleSapien(PApplet sketch, int x, int y, int diameter) {
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = 0;
        this.IS_CONTACT = false;
        this.IS_DEAD = false;

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
     * check object state
     * 
     * @return isDead true or false
     */
    public boolean isDead() {
        return this.IS_DEAD;
    }

    /**
     * set object state true or false
     * 
     * @param IS_DEAD
     */
    public void setDead(boolean IS_DEAD) {
        this.IS_DEAD = IS_DEAD;
    }

    /**
     * explode behavior
     */
    public void explode() {
        p.draw();
        p.update();
    }

    /**
     * set dead state to true, use effect
     */
    public void die() {
        explode();
        IS_DEAD = true;
    }

    /**
     * call die method on object that came in contact.
     */
    public void defend() {
        contactWith.die();
    }

    /**
     * explosion using particle system
     * 
     * @param x
     * @param y
     * @param sketch
     */
    public void createExplosion(int x, int y, PApplet sketch) {
        this.p = new ParticleSystem(x, y, sketch);
    }

    /**
     * set the object that this one made contact with
     * 
     * @param c the object
     */
    public void setContactWith(CircleSapien c) {
        this.contactWith = c;
    }

    /**
     * get obj that this one made contact with
     * 
     * @return CircleSapien object that made contact
     */
    public CircleSapien getContactWith() {
        return this.contactWith;
    }

    /**
     * has the object made contact with another from a different class
     * 
     * @return true if contact
     */
    public boolean madeContact() {
        return this.IS_CONTACT;
    }

    /**
     * distance formula calculates distance between two points on the cartesian
     * plane
     * 
     * @param c object to compare to this
     * @return distance
     */
    public double getDistance(CircleSapien c) {
        return Math.sqrt(Math.pow((c.getX() - x), 2) + Math.pow((c.getY() - y), 2))
                - ((diameter / 2) + (c.getDiameter() / 2));
    }

    /**
     * Takes a CircleSapien object and compares sizes
     * 
     * @return true if the object is larger
     */
    public boolean isLarger() {
        if (diameter > contactWith.getDiameter()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * set the state on this object regarding contact
     * 
     * @param circleSapienSystem all objects to check
     */
    public void setContactFlag(ArrayList<CircleSapien> circleSapienSystem) {
        for (CircleSapien c : circleSapienSystem) {
            // if(touching && !same class && not itself && !contact flag)
            if (getDistance(c) < 0 && c.getClass() != this.getClass() && c != this && !IS_CONTACT) {
                IS_CONTACT = true;
                setContactWith(c);
                createExplosion(x, y, sketch);
            }
        }
    }
}
