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
        circleSapienSystem.addTestHuman(100, 350);
        circleSapienSystem.addTestHuman(200, 400);
        circleSapienSystem.addTestHuman(300, 400);
        circleSapienSystem.addTestZombie(100, 100);
        circleSapienSystem.addTestZombie(200, 100);
        circleSapienSystem.addTestZombie(300, 100);
    }

    public void testSimulation() {
        circleSapienSystem.collide();
        circleSapienSystem.testMove();
        circleSapienSystem.draw();

    }

}
