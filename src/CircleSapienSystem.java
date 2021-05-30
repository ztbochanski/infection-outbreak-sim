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
                (int) sketch.random((float) (sketch.height * .25)), circleSapienSystem));
    }

    /**
     * add human object at random location bottom of window
     */
    public void addRandHuman() {
        addSapien(new Human(sketch, (int) sketch.random(sketch.width),
                sketch.height - (int) sketch.random((float) (sketch.height * .25)), circleSapienSystem));
    }

    public void addTestZombie(int x, int y) {
        addSapien(new Zombie(sketch, x, y, circleSapienSystem));
    }

    public void addTestHuman(int x, int y) {
        addSapien(new Human(sketch, x, y, circleSapienSystem));
    }

    /**
     * move each object in the system
     */
    public void update() {
        for (CircleSapien c : circleSapienSystem) {
            c.move();
        }
    }

    /**
     * move each object in the system
     */
    public void testUpdate() {
        for (CircleSapien c : circleSapienSystem) {
            c.testMove();
        }
    }

    /**
     * draw each object in the system
     */
    public void draw() {
        for (CircleSapien c : circleSapienSystem) {
            c.draw();
        }
    }

    public void killInfected() {
    }

    public void collide() {
        for (CircleSapien c : circleSapienSystem) {
            CircleSapien b = c.getCollision();
            if (b != null)
                System.out.println(b + " crashed into " + c);
        }
    }

}
