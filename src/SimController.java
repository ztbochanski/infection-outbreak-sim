import processing.core.PApplet;

/**
 * Simulator class creates a population system and controls the simulation
 */
public class SimController {
    SapienSystem SapienSystem;
    PApplet sketch;

    public SimController(PApplet sketch) {
        this.sketch = sketch;
        SapienSystem = new SapienSystem(this.sketch);
    }

    /**
     * generate a population of zombies and humans
     */
    public void createSample(float popSize, float zombiePercentage) {
        int totalCount = 0;
        float targetZombiePop = (popSize * (zombiePercentage / 100));
        while (totalCount < popSize) {
            if (totalCount < targetZombiePop) {
                SapienSystem.addRandZombie();
                totalCount++;
            } else {
                SapienSystem.addRandHuman();
                totalCount++;
            }
        }
    }

    /**
     * move each member of the system to their next position
     */
    public void simulate() {
        SapienSystem.setContactFlag();
        SapienSystem.move();
        SapienSystem.draw();
    }

}
