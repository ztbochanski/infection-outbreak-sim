import processing.core.PApplet;
import java.util.ArrayList;

class ParticleSystem {

    private final static int NUMBER_OF_PARTICLES = 10;
    private ArrayList<Particle> particles;
    private int x;
    private int y;

    public ParticleSystem(PApplet sketch) {
        this(sketch.width / 2, sketch.height / 2, NUMBER_OF_PARTICLES, sketch);
    }

    public ParticleSystem(int x, int y, int numberOfParticles, PApplet sketch) {
        this.x = x;
        this.y = y;
        particles = new ArrayList<Particle>();
        for (int i = 0; i < numberOfParticles; ++i) {
            particles.add(new Particle(x, y, sketch));
        }
    }

    public void update() {
        for (Particle p : particles)
            p.move();
    }

    public void draw() {
        for (Particle p : particles)
            p.draw();
    }

    public boolean allOffScreen() {
        for (Particle p : particles) {
            if (!p.isOffScreen()) {
                return false;
            }
        }
        return true;
    }
}