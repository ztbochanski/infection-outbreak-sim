import java.util.ArrayList;

import processing.core.PApplet;

/**
 * CircleSapienSystem class represents a system of CircleSapien Objects
 */
public class CircleSapienSystem {
    PApplet sketch;
    private ArrayList<CircleSapien> circleSapienSystem;

    /**
     * CircleSapienSystem constructor creates and array list to store sapien objects
     */
    public CircleSapienSystem(PApplet sketch) {
        this.sketch = sketch;
        this.circleSapienSystem = new ArrayList<CircleSapien>();
    }

    public ArrayList<CircleSapien> getSapienArray() {
        return this.circleSapienSystem;
    }

    /**
     * get size of the system
     * 
     * @return size
     */
    public int getSize() {
        return circleSapienSystem.size();
    }

    /**
     * add object to system
     * 
     * @param c object
     */
    public void addSapien(CircleSapien c) {
        circleSapienSystem.add(c);
    }

    /**
     * remove object at index
     * 
     * @param index
     */
    public void removeSapien(int index) {
        circleSapienSystem.remove(index);
    }

    /**
     * get object at index
     * 
     * @param index
     * @return
     */
    public CircleSapien getSapien(int index) {
        return circleSapienSystem.get(index);
    }

    /**
     * get index of object passed in
     * 
     * @param c
     * @return index
     */
    public int getIndexOf(CircleSapien c) {
        return circleSapienSystem.indexOf(c);
    }

    /**
     * set object in array at passed in index
     * 
     * @param index
     * @param c
     */
    public void setSapienAt(int index, CircleSapien c) {
        circleSapienSystem.set(index, c);
    }

    /**
     * add zombie object at random location top of window
     */
    public void addRandZombie() {
        addSapien(new Zombie(sketch, (int) sketch.random(sketch.width),
                (int) sketch.random((float) (sketch.height * .25))));
    }

    /**
     * add human object at random location bottom of window
     */
    public void addRandHuman() {
        addSapien(new Human(sketch, (int) sketch.random(sketch.width),
                sketch.height - (int) sketch.random((float) (sketch.height * .25))));
    }

    /**
     * add a test zombie specify location
     * 
     * @param x
     * @param y
     */
    public void addTestZombie(int x, int y) {
        addSapien(new Zombie(sketch, x, y));
    }

    /**
     * add a test human specify location
     * 
     * @param x
     * @param y
     */
    public void addTestHuman(int x, int y) {
        addSapien(new Human(sketch, x, y));
    }

    /**
     * move each object in the system
     */
    public void move() {
        for (CircleSapien c : circleSapienSystem) {
            c.move();
        }
    }

    /**
     * move each object in the system with constant motion
     */
    public void testMove() {
        for (CircleSapien c : circleSapienSystem) {
            c.testMove();
        }
    }

    /**
     * draw each living object in the system
     */
    public void draw() {
        for (CircleSapien c : circleSapienSystem) {
            if (!c.isDead())
                c.draw();
        }
    }

    /**
     * remove object's flagged as dead from the array
     */
    public void removeDead() {
        for (int i = circleSapienSystem.size() - 1; i >= 0; i--) {
            if (circleSapienSystem.get(i).isDead()) {
                circleSapienSystem.remove(i);
            }
        }
    }

    /**
     * for every frame check contact among each object in the array, set object
     * flags
     */
    public void setCollision() {
        for (CircleSapien c : circleSapienSystem) {
            c.setCollision(circleSapienSystem);
        }
    }

    public void testInteraction() {
        for (CircleSapien c : circleSapienSystem) {
            if (c.isCarrier())
                System.out.println(c.getClass());
        }
    }
}
