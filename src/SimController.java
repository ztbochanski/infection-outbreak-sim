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

    /**
     * move each member of the system to their next position
     */
    public void simulate() {
        circleSapienSystem.move();
        circleSapienSystem.draw();
    }

}
