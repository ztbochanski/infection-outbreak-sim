import processing.core.PApplet;

public class Counter {
    private PApplet sketch;
    private int humanCount;
    private int zombieCount;

    public Counter(PApplet sketch) {
        this.sketch = sketch;
    }

    public void setHumanCount(int humanCount) {
        this.humanCount = humanCount;
    }

    public void setZombieCount(int zombieCount) {
        this.zombieCount = zombieCount;
    }

    public void draw() {
        sketch.fill(255);
        sketch.textSize(18);
        sketch.text("Humans: " + humanCount, (sketch.width / 2) - 50, sketch.height - 100);
        sketch.text("Zombies: " + zombieCount, (sketch.width / 2) - 50, 100);
    }
}
