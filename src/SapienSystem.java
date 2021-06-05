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
            c.draw();
        }
    }

    public void actionOnContact() {
        for (int i = 0; i < sapiens.size(); i++) {
            Sapien h = sapiens.get(i);

            // if human is at i, then loop backwards and find zombies
            if (h.getClass() == Human.class) {
                for (int j = sapiens.size() - 1; j >= 0; j--) {
                    Sapien z = sapiens.get(j);

                    // if zombie at j, and touching human, and human won
                    if (z.getClass() == Zombie.class) {
                        if (h.isTouching(z)) {
                            if (h.isLarger(z) && h.isWinning(75)) {
                                createExplosion(z);
                                sapiens.remove(j);
                            } else {
                                if (h.isInfected(15)) {
                                    sapiens.add(new Zombie(sketch, h.getX(), h.getY(), h.getDiameter()));
                                } else {
                                    createExplosion(h);
                                }
                                sapiens.remove(h);
                            }
                        }
                    }
                }
            }
        }
    }

    public void createExplosion(Sapien s) {
        ParticleSystem p = new ParticleSystem(s.getX(), s.getY(), s.getDiameter() * 2, sketch);
        particleSystems.add(p);
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
