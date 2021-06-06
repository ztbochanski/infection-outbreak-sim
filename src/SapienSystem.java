import java.util.ArrayList;
import processing.core.PApplet;

/**
 * SapienSystem class represents a system of Sapien Objects
 */
public class SapienSystem {
    PApplet sketch;
    private ArrayList<Sapien> sapiens;
    private ArrayList<ParticleSystem> particleSystems;
    private String SOUND = "src/sounds/laser.mp3";
    private SoundPlayer soundPlayer;

    /**
     * SapienSystem constructor creates and array list to store sapien objects
     */
    public SapienSystem(PApplet sketch) {
        this.sketch = sketch;
        this.sapiens = new ArrayList<Sapien>();
        this.particleSystems = new ArrayList<ParticleSystem>();
        this.soundPlayer = new SoundPlayer(sketch, SOUND);
    }

    /**
     * get count of the human system
     * 
     * @return size
     */
    public int getHumanCount() {
        int count = 0;
        for (Sapien s : sapiens) {
            if (s instanceof Human)
                count++;
        }
        return count;
    }

    /**
     * get count of the zombie system
     * 
     * @return size
     */
    public int getZombieCount() {
        int count = 0;
        for (Sapien s : sapiens) {
            if (s instanceof Zombie)
                count++;
        }
        return count;
    }

    /**
     * add object to system
     * 
     * @param s object
     */
    public void addSapien(Sapien s) {
        sapiens.add(s);
    }

    /**
     * get index of object passed in
     * 
     * @param s
     * @return index
     */
    public int getIndexOf(Sapien s) {
        return sapiens.indexOf(s);
    }

    /**
     * set object in array at passed in index
     * 
     * @param index
     * @param s
     */
    public void setSapienAt(int index, Sapien s) {
        sapiens.set(index, s);
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
        for (Sapien s : sapiens) {
            s.move();
        }
    }

    /**
     * move each object in the system with constant motion
     */
    public void testMove() {
        for (Sapien s : sapiens) {
            s.testMove();
        }
    }

    /**
     * draw each living object in the system
     */
    public void draw() {
        for (Sapien s : sapiens) {
            s.draw();
        }
    }

    /**
     * defend, die, or get infected logic on contact with carrier of disease
     */
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
                                soundPlayer.playSound();
                                sapiens.remove(j);
                            } else {
                                if (h.isInfected(15)) {
                                    sapiens.add(new Zombie(sketch, h.getX(), h.getY(), h.getDiameter()));
                                    sapiens.remove(h);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * make new particle system for explosion
     * 
     * @param s object position to create for
     */
    public void createExplosion(Sapien s) {
        ParticleSystem p = new ParticleSystem(s.getX(), s.getY(), s.getDiameter(), sketch);
        particleSystems.add(p);
    }

    /**
     * update the particle system
     */
    public void updateParticles() {
        for (ParticleSystem p : particleSystems) {
            p.update();
        }
    }

    /**
     * draw particle system position
     */
    public void drawParticles() {
        for (ParticleSystem p : particleSystems) {
            p.draw();
        }
    }

}
