import processing.core.PApplet;

/**
 * Test class creates a population system and controls the test environment
 */
public class TestController {
    SapienSystem SapienSystem;
    PApplet sketch;

    public TestController(PApplet sketch) {
        this.sketch = sketch;
        SapienSystem = new SapienSystem(this.sketch);
    }

    public void createTestSample() {
        SapienSystem.addTestHuman(100, 130);
        SapienSystem.addTestHuman(200, 160);
        SapienSystem.addTestHuman(300, 190);
        SapienSystem.addTestZombie(100, 100);
        SapienSystem.addTestZombie(200, 100);
        SapienSystem.addTestZombie(300, 100);
    }

    public void testSimulation() {
        SapienSystem.setContactFlag();
        SapienSystem.testMove();
        SapienSystem.draw();
        SapienSystem.testActionOnContact("DIE"); // DIE, IMMUNE, CARRIER
    }

    public void runModel(float deathRate, float incubationRate, float resistanceRate) {
        int exposedCount = SapienSystem.getExposedCount();
        if (exposedCount > 0) {
            int deathCount = (int) (exposedCount * (deathRate / 100));
            int carrierCount = (int) (exposedCount * (incubationRate / 100));
            int immuneCount = (int) (exposedCount * (resistanceRate / 100));
            // SapienSystem.applyDeathCount(deathCount);
            // SapienSystem.applyCarrierCount(deathCount);
            // SapienSystem.applyImmuneCount(deathCount);
        }
    }

    public void clean() {
        SapienSystem.removeDead();
    }

}
