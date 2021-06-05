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
    private boolean isExposed;
    private boolean isDead;

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
        this.isExposed = false;
        this.isDead = false;

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
        this.isExposed = false;
        this.isDead = false;

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
        return this.isDead;
    }

    /**
     * set object state true or false
     * 
     * @param isDead
     */
    public void setDead(boolean isDead) {
        this.isDead = isDead;
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
        isDead = true;
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
        this.p = new ParticleSystem(x, y, 50, sketch);
    }

    /**
     * set the object that this one made contact with
     * 
     * @param c the object
     */
    public void setContactWith(Sapien c) {
        this.contactWith = c;
    }

    /**
     * get obj that this one made contact with
     * 
     * @return Sapien object that made contact
     */
    public Sapien getContactWith() {
        return this.contactWith;
    }

    /**
     * has the object made contact and exposed to infected from a different class
     * 
     * @return true if object exposed to the infection
     */
    public boolean isExposed() {
        return this.isExposed;
    }

    /**
     * distance formula calculates distance between two points on the cartesian
     * plane
     * 
     * @param c object to compare to this
     * @return distance
     */
    public double getDistance(Sapien c) {
        return Math.sqrt(Math.pow((c.getX() - x), 2) + Math.pow((c.getY() - y), 2))
                - ((diameter / 2) + (c.getDiameter() / 2));
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

    public boolean isWinning(int probability) {
        int randNum = (int) sketch.random(0, 100);
        return (randNum < probability);
    }

    public boolean isInfected(int probability) {
        int randNum = (int) sketch.random(0, 100);
        return (randNum < probability);
    }

    /**
     * set the state on this object regarding contact
     * 
     * @param SapienSystem all objects to check
     */
    public void setContactFlag(ArrayList<Sapien> SapienSystem) {
        for (Sapien c : SapienSystem) {
            // if(touching && !same class && not itself && !contact flag)
            if (getDistance(c) < 0 && c.getClass() != this.getClass() && c != this && !isExposed) {
                isExposed = true;
                setContactWith(c);
                createExplosion(x, y, sketch);
            }
        }
    }
}
