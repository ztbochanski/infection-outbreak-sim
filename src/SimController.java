import processing.core.PApplet;

/**
 * Simulator class creates a population system and controls the simulation
 */
public class SimController {
    CircleSapienSystem circleSapienSystem;
    PApplet sketch;

    public SimController(PApplet sketch) {
        this.sketch = sketch;
        circleSapienSystem = new CircleSapienSystem(this.sketch);
    }

    /**
     * generate a population of zombies and humans
     */
    public void createSample(float popSize, float zombiePercentage) {
        int totalCount = 0;
        float targetZombiePop = (popSize * (zombiePercentage / 100));
        while (totalCount < popSize) {
            if (totalCount < targetZombiePop) {
                circleSapienSystem.addRandZombie();
                totalCount++;
            } else {
                circleSapienSystem.addRandHuman();
                totalCount++;
            }
        }
    }

    public void simulateMovement() {
        circleSapienSystem.update();
        circleSapienSystem.draw();
    }

    public void contactBehavior() {
        for (int i = 0; i < circleSapienSystem.getSize(); i++) {
            circleSapienSystem.getSapien(i).collisionWith(circleSapienSystem.getSapienArray());
            // CircleSapien sapienA = circleSapienSystem.getSapien(i);
            // for (CircleSapien sapienB : circleSapienSystem.getSapienArray()) {
            // if (sapienA != sapienB && sapienA.madeContact(sapienB) && sapienA.getClass()
            // != sapienB.getClass()) {
            // if (sapienA.getClass() == Human.class) {
            // System.out.println(sapienA.getClass() + " is a human");
            // } else {
            // System.out.println(sapienA.getClass() + " is a zombie");
            // }

            // }
            // }
        }
    }

    public void convertToZombie(CircleSapien human) {
    }

    // public void addZombie() {
    // CircleSapien zombie = new Zombie(sketch, (int) sketch.random(sketch.width),
    // (int) sketch.random((float) (sketch.height * .25)));
    // circleSapienSystem.addSapien(zombie);
    // }

    // public void addHuman() {
    // CircleSapien human = new Human(sketch, (int) sketch.random(sketch.width),
    // sketch.height - (int) sketch.random((float) (sketch.height * .25)));
    // circleSapienSystem.addSapien(human);
    // }

}
