import processing.core.PApplet;

/**
 * Simulator class creates a population system and controls the simulation
 */
public class SimController {
    SapienSystem sapienSystem;
    PApplet sketch;
    Counter counter;

    public SimController(PApplet sketch) {
        this.sketch = sketch;
        sapienSystem = new SapienSystem(this.sketch);
        counter = new Counter(this.sketch);

    }

    /**
     * generate a population of zombies and humans
     */
    public void createSample(int sampleSize) {
        int randNum = (int) sketch.random(0, 100);
        if (randNum < 33)
            generatePopulation(sampleSize, 25);
        else if (randNum < 66)
            generatePopulation(sampleSize, 50);
        else
            generatePopulation(sampleSize, 75);

    }

    public void generatePopulation(int sampleSize, int probZombie) {
        int count = 0;
        while (count < sampleSize) {
            int randNum = (int) sketch.random(0, 100);
            generateIndividual(randNum, probZombie);
            count++;
        }
    }

    public void generateIndividual(int randNum, int probability) {
        if (randNum < probability)
            sapienSystem.addRandZombie();
        else
            sapienSystem.addRandHuman();
    }

    /**
     * move each member of the system to their next position and simulate model
     */
    public void simulate() {
        counter.setHumanCount(sapienSystem.getHumanCount());
        counter.setZombieCount(sapienSystem.getZombieCount());
        counter.draw();
        sapienSystem.actionOnContact();
        sapienSystem.drawParticles();
        sapienSystem.updateParticles();
        sapienSystem.move();
        sapienSystem.draw();
    }

}
