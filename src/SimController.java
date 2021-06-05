import processing.core.PApplet;

/**
 * Simulator class creates a population system and controls the simulation
 */
public class SimController {
    SapienSystem sapienSystem;
    PApplet sketch;

    public SimController(PApplet sketch) {
        this.sketch = sketch;
        sapienSystem = new SapienSystem(this.sketch);
    }

    /**
     * generate a population of zombies and humans
     */
    public void createSample(float popSize, float zombiePercentage) {
        int totalCount = 0;
        float targetZombiePop = (popSize * (zombiePercentage / 100));
        while (totalCount < popSize) {
            if (totalCount < targetZombiePop) {
                sapienSystem.addRandZombie();
                totalCount++;
            } else {
                sapienSystem.addRandHuman();
                totalCount++;
            }
        }
    }

    /**
     * move each member of the system to their next position and simulate model
     */
    public void simulate() {
        sapienSystem.actionOnContact();
        sapienSystem.drawParticles();
        sapienSystem.updateParticles();
        sapienSystem.move();
        sapienSystem.draw();
    }

}
