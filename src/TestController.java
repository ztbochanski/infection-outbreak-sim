import processing.core.PApplet;

/**
 * Test class creates a population system and controls the test environment
 */
public class TestController {
    CircleSapienSystem circleSapienSystem;
    PApplet sketch;

    public TestController(PApplet sketch) {
        this.sketch = sketch;
        circleSapienSystem = new CircleSapienSystem(this.sketch);
    }

    public void createTestSample() {
        circleSapienSystem.addTestHuman(100, 130);
        circleSapienSystem.addTestHuman(200, 160);
        circleSapienSystem.addTestHuman(300, 190);
        circleSapienSystem.addTestZombie(100, 100);
        circleSapienSystem.addTestZombie(200, 100);
        circleSapienSystem.addTestZombie(300, 100);
    }

    public void testSimulation() {
        circleSapienSystem.setContactFlag();
        circleSapienSystem.testMove();
        circleSapienSystem.draw();
    }

    public void testInteraction() {
        circleSapienSystem.testInteraction();
    }

    public void runModel(float deathRate, float incubationRate, float resistanceRate) {
        int exposedCount = circleSapienSystem.getExposed();
        // float deathCount = (getContactCount()*(deathRate/100));

    }

    public void clean() {
        circleSapienSystem.removeDead();
    }

}
