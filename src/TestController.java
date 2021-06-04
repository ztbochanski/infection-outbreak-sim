import processing.core.PApplet;

/**
 * Test class creates a population system and controls the test environment
 */
public class TestController {
    SapienSystem sapienSystem;
    PApplet sketch;

    public TestController(PApplet sketch) {
        this.sketch = sketch;
        sapienSystem = new SapienSystem(this.sketch);
    }

    public void createTestSample() {
        sapienSystem.addTestHuman(100, 130);
        sapienSystem.addTestHuman(200, 160);
        sapienSystem.addTestHuman(300, 190);
        sapienSystem.addTestZombie(100, 100);
        sapienSystem.addTestZombie(200, 100);
        sapienSystem.addTestZombie(300, 100);
    }

    public void testSimulation() {
        sapienSystem.actionOnContact();
        sapienSystem.drawParticles();
        sapienSystem.updateParticles();
        sapienSystem.testMove();
        sapienSystem.draw();
    }

    public void runModel(float deathRate, float incubationRate, float resistanceRate) {
        int exposedCount = sapienSystem.getExposedCount();
        if (exposedCount > 0) {
            int deathCount = (int) (exposedCount * (deathRate / 100));
            int carrierCount = (int) (exposedCount * (incubationRate / 100));
            int immuneCount = (int) (exposedCount * (resistanceRate / 100));
            // sapienSystem.applyDeathCount(deathCount);
            // sapienSystem.applyCarrierCount(deathCount);
            // sapienSystem.applyImmuneCount(deathCount);
        }
    }

}
