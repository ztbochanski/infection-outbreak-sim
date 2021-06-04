import java.util.ArrayList;
import processing.core.PApplet;

/**
 * SapienSystem class represents a system of Sapien Objects
 */
public class SapienSystem {
    PApplet sketch;
    private ArrayList<Sapien> sapienSystem;

    /**
     * SapienSystem constructor creates and array list to store sapien objects
     */
    public SapienSystem(PApplet sketch) {
        this.sketch = sketch;
        this.sapienSystem = new ArrayList<Sapien>();
    }

    public ArrayList<Sapien> getSapienArray() {
        return this.sapienSystem;
    }

    /**
     * get size of the system
     * 
     * @return size
     */
    public int getSize() {
        return sapienSystem.size();
    }

    /**
     * add object to system
     * 
     * @param c object
     */
    public void addSapien(Sapien c) {
        sapienSystem.add(c);
    }

    /**
     * remove object at index
     * 
     * @param index
     */
    public void removeSapien(int index) {
        sapienSystem.remove(index);
    }

    /**
     * get object at index
     * 
     * @param index
     * @return
     */
    public Sapien getSapien(int index) {
        return sapienSystem.get(index);
    }

    /**
     * get index of object passed in
     * 
     * @param c
     * @return index
     */
    public int getIndexOf(Sapien c) {
        return sapienSystem.indexOf(c);
    }

    /**
     * set object in array at passed in index
     * 
     * @param index
     * @param c
     */
    public void setSapienAt(int index, Sapien c) {
        sapienSystem.set(index, c);
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
        for (Sapien c : sapienSystem) {
            c.move();
        }
    }

    /**
     * move each object in the system with constant motion
     */
    public void testMove() {
        for (Sapien c : sapienSystem) {
            c.testMove();
        }
    }

    /**
     * draw each living object in the system
     */
    public void draw() {
        for (Sapien c : sapienSystem) {
            if (!c.isDead())
                c.draw();
        }
    }

    /**
     * for every frame check contact among each object in the array, set object
     * flags
     */
    public void setContactFlag() {
        for (Sapien c : sapienSystem) {
            c.setContactFlag(sapienSystem);
        }
    }

    /**
     * get the number who were exposed to the infection each step
     * 
     * @return number of exposed objects
     */
    public int getExposedCount() {
        int exposedCount = 0;
        for (Sapien c : sapienSystem) {
            if (c.isExposed() && c.getClass() == Human.class)
                exposedCount++;
        }
        return exposedCount;
    }

    public void testActionOnContact(String action) {
        for (int i = sapienSystem.size() - 1; i >= 0; i--) {
            Sapien c = sapienSystem.get(i);
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
                        sapienSystem.add(new Zombie(sketch, c.getX(), c.getY(), c.getDiameter()));
                        sapienSystem.remove(i);
                    }
                    break;
            }
        }
    }

    // public void actionOnContact() {
    // for (Sapien s : sapienSystem) {
    // if (s.getClass() == Human.class) {
    // for (int i = sapienSystem.size() - 1; i >= 0; i--) {
    // if (sapienSystem.get(i).getClass() == Zombie.class) {
    // sapienSystem.remove(i);
    // }
    // }
    // }
    // }
    // }

    public void actionOnContact() {
        for (int i = 0; i < sapienSystem.size(); i++) {
            if (sapienSystem.get(i).getClass() == Human.class) {
                for (int j = sapienSystem.size() - 1; j >= 0; j--) {
                    if (sapienSystem.get(j).getClass() == Zombie.class) {
                        if (sapienSystem.get(i).isTouching(sapienSystem.get(j))) {
                            sapienSystem.remove(j);
                        }
                    }
                }
            }
        }
    }

}
