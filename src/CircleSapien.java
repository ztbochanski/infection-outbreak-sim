import java.util.ArrayList;
import processing.core.PApplet;

/**
 * The CircleSapien class models the behaviors of every homo sapien like circle
 */
public abstract class CircleSapien {
    private PApplet sketch;
    private ParticleSystem p;
    // private ArrayList<CircleSapien> circleSapienSystem;
    private int x, y;
    private int diameter;
    private int color;
    private boolean IS_CARRIER;
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
        // this.circleSapienSystem = circleSapienSystem;
        this.x = x;
        this.y = y;
        this.diameter = (int) this.sketch.random(10, 40);
        this.color = 0;
        this.IS_CARRIER = false;
        this.IS_DEAD = false;
    }

    /**
     * specify if the object is a carrier from creation
     * 
     * @param sketch
     * @param x
     * @param y
     * @param IS_CARRIER
     */
    public CircleSapien(PApplet sketch, int x, int y, boolean IS_CARRIER) {
        this.sketch = sketch;
        // this.circleSapienSystem = circleSapienSystem;
        this.x = x;
        this.y = y;
        this.diameter = (int) this.sketch.random(10, 40);
        this.color = 0;
        this.IS_CARRIER = IS_CARRIER;
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
     * kill behavior
     */
    public abstract void kill();

    /**
     * convert behavior
     */
    public abstract void convert();

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
     * get contact
     * 
     * @return contact
     */
    public boolean isCarrier() {
        return this.IS_CARRIER;
    }

    /**
     * set contact
     * 
     * @param contact true or false
     */
    public void setCarrier(boolean IS_CARRIER) {
        this.IS_CARRIER = IS_CARRIER;
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
     * explosion using particle system
     * 
     * @param x
     * @param y
     * @param sketch
     */
    public void createExplosion(int x, int y, PApplet sketch) {
        this.p = new ParticleSystem(x, y, sketch);
    }

    public void setCollision(ArrayList<CircleSapien> circleSapienSystem) {
        for (CircleSapien c : circleSapienSystem) {
            // if(physically collided && different subclasses && not itself && not carrier)
            if (getDistance(c) < 0 && c.getClass() != this.getClass() && c != this && !IS_CARRIER) {
                IS_CARRIER = true;
                createExplosion(x, y, sketch);
                System.out.println(this.getClass());
            }
        }
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
