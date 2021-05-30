import java.util.ArrayList;

import processing.core.PApplet;

/**
 * The CircleSapien class models the behaviors of every homo sapien like circle
 */
public abstract class CircleSapien {
    private PApplet sketch;
    private ParticleSystem p;
    private int x, y;
    private int diameter;
    private int color;
    private boolean contact;

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
        this.p = new ParticleSystem(this.x, this.y, this.sketch);
        this.diameter = (int) this.sketch.random(10, 40);
        this.color = 0;
        this.contact = false;

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
     * kill behavior
     */
    public abstract void kill();

    /**
     * explode behavior
     */
    public void explode() {
        p.draw();
        p.update();
    }

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
    public boolean getContact() {
        return this.contact;
    }

    /**
     * set contact
     * 
     * @param contact true or false
     */
    public void setContact(boolean contact) {
        this.contact = contact;
    }

    /**
     * madeContact uses distance formula for determine if the passed in object has a
     * distance away of 0 or less. Sets the contact member variable true to flag if
     * contact is made.
     * 
     * @param c CircleSapien object to check for a collision
     * @return true if contact is made
     */
    public boolean madeContact(CircleSapien c) {
        double distanceFormula = Math.sqrt(Math.pow((c.getX() - x), 2) + Math.pow((c.getY() - y), 2)) - (diameter / 2)
                - (c.getDiameter() / 2);
        if (distanceFormula <= 0 && !contact) {
            setContact(true);
        }
        return contact;
    }

    /**
     * checks to see if subclasses collide with each other
     * 
     * @param circleSapienSystem
     */
    public boolean collisionWith(ArrayList<CircleSapien> circleSapienSystem) {
        CircleSapien sapienA = this;
        for (CircleSapien sapienB : circleSapienSystem) {
            if (sapienB != sapienA && madeContact(sapienB) && sapienA.getClass() != sapienB.getClass()) {
                return true;
            } else
                return false;
        }
        return contact;
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
