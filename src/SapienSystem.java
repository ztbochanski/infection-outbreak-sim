import java.util.ArrayList;
import processing.core.PApplet;

/**
 * SapienSystem class represents a system of Sapien Objects
 */
public class SapienSystem {
    PApplet sketch;
    private ArrayList<Sapien> sapiens;
    private ArrayList<ParticleSystem> particleSystems;

    /**
     * SapienSystem constructor creates and array list to store sapien objects
     */
    public SapienSystem(PApplet sketch) {
        this.sketch = sketch;
        this.sapiens = new ArrayList<Sapien>();
        this.particleSystems = new ArrayList<ParticleSystem>();
    }

    /**
     * get size of the system
     * 
     * @return size
     */
    public int getSize() {
        return sapiens.size();
    }

    /**
     * add object to system
     * 
     * @param c object
     */
    public void addSapien(Sapien c) {
        sapiens.add(c);
    }

    /**
     * remove object at index
     * 
     * @param index
     */
    public void removeSapien(int index) {
        sapiens.remove(index);
    }

    /**
     * get object at index
     * 
     * @param index
     * @return
     */
    public Sapien getSapien(int index) {
        return sapiens.get(index);
    }

    /**
     * get index of object passed in
     * 
     * @param c
     * @return index
     */
    public int getIndexOf(Sapien c) {
        return sapiens.indexOf(c);
    }

    /**
     * set object in array at passed in index
     * 
     * @param index
     * @param c
     */
    public void setSapienAt(int index, Sapien c) {
        sapiens.set(index, c);
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
        for (Sapien c : sapiens) {
            c.move();
        }
    }

    /**
     * move each object in the system with constant motion
     */
    public void testMove() {
        for (Sapien c : sapiens) {
            c.testMove();
        }
    }

    /**
     * draw each living object in the system
     */
    public void draw() {
        for (Sapien c : sapiens) {
            if (!c.isDead())
                c.draw();
        }
    }

    /**
     * for every frame check contact among each object in the array, set object
     * flags
     */
    public void setContactFlag() {
        for (Sapien c : sapiens) {
            c.setContactFlag(sapiens);
        }
    }

    /**
     * get the number who were exposed to the infection each step
     * 
     * @return number of exposed objects
     */
    public int getExposedCount() {
        int exposedCount = 0;
        for (Sapien c : sapiens) {
            if (c.isExposed() && c.getClass() == Human.class)
                exposedCount++;
        }
        return exposedCount;
    }

    public void testActionOnContact(String action) {
        for (int i = sapiens.size() - 1; i >= 0; i--) {
            Sapien c = sapiens.get(i);
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
                        sapiens.add(new Zombie(sketch, c.getX(), c.getY(), c.getDiameter()));
                        sapiens.remove(i);
                    }
                    break;
            }
        }
    }

    // public void actionOnContact() {
    // for (Sapien s : sapiens) {
    // if (s.getClass() == Human.class) {
    // for (int i = sapiens.size() - 1; i >= 0; i--) {
    // if (sapiens.get(i).getClass() == Zombie.class) {
    // sapiens.remove(i);
    // }
    // }
    // }
    // }
    // }

    public void actionOnContact() {
        for (int i = 0; i < sapiens.size(); i++) {
            if (sapiens.get(i).getClass() == Human.class) {
                for (int j = sapiens.size() - 1; j >= 0; j--) {
                    if (sapiens.get(j).getClass() == Zombie.class) {
                        if (sapiens.get(i).isTouching(sapiens.get(j))) {
                            if (sapiens.get(i).isLarger(sapiens.get(j))) {
                                Sapien z = sapiens.get(j);
                                ParticleSystem p = new ParticleSystem(z.getX(), z.getY(), z.getDiameter() * 2, sketch);
                                particleSystems.add(p);
                                sapiens.remove(j);
                            } else
                                sapiens.remove(i);
                        }
                    }
                }
            }
        }
    }

    public void updateParticles() {
        for (ParticleSystem p : particleSystems) {
            p.update();
        }
    }

    public void drawParticles() {
        for (ParticleSystem p : particleSystems) {
            p.draw();
        }
    }

}
