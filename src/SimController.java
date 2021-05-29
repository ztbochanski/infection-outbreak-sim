import processing.core.PApplet;

/**
 * Simulator class creates a population system and controls the simulation
 */
public class SimController {
    CircleSapienSystem circleSapienSystem;
    PApplet sketch;

    public SimController(PApplet sketch) {
        this.sketch = sketch;
        circleSapienSystem = new CircleSapienSystem();
    }

    /**
     * generate a population of zombies and humans
     */
    public void createPopulation(float popSize, float zombiePercentage) {
        int totalCount = 0;
        float targetZombiePop = (popSize * (zombiePercentage / 100));
        while (totalCount < popSize) {
            if (totalCount < targetZombiePop) {
                // add zombies
                totalCount++;
            } else {
                // add humans
                totalCount++;
            }
        }
    }

    public void start() {
        // invoke human/zombie behaviors
    }

    public void addZombie(Point point) {
        // add zombie to system
    }

    public void addHuman() {
        // add human to system
    }

}
