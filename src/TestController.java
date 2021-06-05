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
        sapienSystem.addTestHuman(100, 150);
        sapienSystem.addTestHuman(200, 200);
        sapienSystem.addTestHuman(300, 250);
        sapienSystem.addTestHuman(400, 300);
        sapienSystem.addTestZombie(100, 100);
        sapienSystem.addTestZombie(200, 100);
        sapienSystem.addTestZombie(300, 100);
        sapienSystem.addTestZombie(400, 100);
    }

    public void testSimulation() {
        sapienSystem.actionOnContact();
        sapienSystem.drawParticles();
        sapienSystem.updateParticles();
        sapienSystem.testMove();
        sapienSystem.draw();
    }
}
