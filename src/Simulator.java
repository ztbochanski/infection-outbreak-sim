import processing.core.PApplet;

/**
 * Simulator class creates a population system and controls the simulation
 */
public class Simulator {
    CircleSapienSystem circleSapienSystem;
    PApplet sketch;

    public Simulator(PApplet sketch) {
        this.sketch = sketch;
        circleSapienSystem = new CircleSapienSystem();
        int count = 0;
        while (count < 30) {
            CircleSapien human = new Human(sketch, (int) sketch.random(500), (int) sketch.random(500));
            CircleSapien zombie = new Zombie(sketch, (int) sketch.random(500), (int) sketch.random(500));
            circleSapienSystem.addSapien(human);
            circleSapienSystem.addSapien(zombie);
            count++;
        }
    }

    /**
     * generate a 50-50 population of zombies and humans
     */
    public void generateFiftyFiftyPopulation() {
        // sample population with assigned points
        // zombies top .25 height
        // humans bottom .25 height
        // 50% zombies, 50% humans
        int count = 0;
        while (count < 30) {
            CircleSapien human = new Human(sketch, (int) sketch.random(500), (int) sketch.random(500));
            CircleSapien zombie = new Zombie(sketch, (int) sketch.random(500), (int) sketch.random(500));
            circleSapienSystem.addSapien(human);
            circleSapienSystem.addSapien(zombie);
            count++;
        }
    }

    // public void draw() {
    // for (int i = 0; i < circleSapienSystem.getSize() - 1; i++) {
    // circleSapienSystem.getSapien(i).draw();
    // }
    // }

}
