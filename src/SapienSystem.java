import java.util.ArrayList;
import processing.core.PApplet;

/**
 * SapienSystem class represents a system of Sapien Objects
 */
public class SapienSystem {
    PApplet sketch;
    private ArrayList<Sapien> SapienSystem;

    /**
     * SapienSystem constructor creates and array list to store sapien objects
     */
    public SapienSystem(PApplet sketch) {
        this.sketch = sketch;
        this.SapienSystem = new ArrayList<Sapien>();
    }

    public ArrayList<Sapien> getSapienArray() {
        return this.SapienSystem;
    }

    /**
     * get size of the system
     * 
     * @return size
     */
    public int getSize() {
        return SapienSystem.size();
    }

    /**
     * add object to system
     * 
     * @param c object
     */
    public void addSapien(Sapien c) {
        SapienSystem.add(c);
    }

    /**
     * remove object at index
     * 
     * @param index
     */
    public void removeSapien(int index) {
        SapienSystem.remove(index);
    }

    /**
     * get object at index
     * 
     * @param index
     * @return
     */
    public Sapien getSapien(int index) {
        return SapienSystem.get(index);
    }

    /**
     * get index of object passed in
     * 
     * @param c
     * @return index
     */
    public int getIndexOf(Sapien c) {
        return SapienSystem.indexOf(c);
    }

    /**
     * set object in array at passed in index
     * 
     * @param index
     * @param c
     */
    public void setSapienAt(int index, Sapien c) {
        SapienSystem.set(index, c);
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
        for (Sapien c : SapienSystem) {
            c.move();
        }
    }

    /**
     * move each object in the system with constant motion
     */
    public void testMove() {
        for (Sapien c : SapienSystem) {
            c.testMove();
        }
    }

    /**
     * draw each living object in the system
     */
    public void draw() {
        for (Sapien c : SapienSystem) {
            if (!c.isDead())
                c.draw();
        }
    }

    /**
     * remove object's flagged as dead from the array
     */
    public void removeDead() {
        for (int i = SapienSystem.size() - 1; i >= 0; i--) {
            if (SapienSystem.get(i).isDead()) {
                SapienSystem.remove(i);
            }
        }
    }

    /**
     * for every frame check contact among each object in the array, set object
     * flags
     */
    public void setContactFlag() {
        for (Sapien c : SapienSystem) {
            c.setContactFlag(SapienSystem);
        }
    }

    /**
     * get the number who were exposed to the infection each step
     * 
     * @return number of exposed objects
     */
    public int getExposedCount() {
        int exposedCount = 0;
        for (Sapien c : SapienSystem) {
            if (c.isExposed() && c.getClass() == Human.class)
                exposedCount++;
        }
        return exposedCount;
    }

    public void testActionOnContact(String action) {
        for (int i = SapienSystem.size() - 1; i >= 0; i--) {
            Sapien c = SapienSystem.get(i);
            switch (action) {
                case "DIE":
                    if (c.isExposed() && c.getClass() == Human.class)
                        c.die();
                    break;
                case "IMMUNE":
                    if (c.isExposed() && c.getClass() == Human.class)
                        c.defend();
                    break;
                case "CARRIER":
                    if (c.isExposed() && c.getClass() == Human.class) {
                        SapienSystem.add(new Zombie(sketch, c.getX(), c.getY(), c.getDiameter()));
                        SapienSystem.remove(i);
                    }
                    break;
            }
        }
    }

}
