import processing.core.PApplet;

public class Walker {
    private final int RIGHT = 1;
    private final int LEFT = 1;
    private final int DOWN = 1;
    private final int UP = 1;
    int x, y;
    PApplet sketch;

    public Walker(PApplet sketch) {
        this.sketch = sketch;
        this.x = sketch.width / 2;
        this.y = sketch.height / 2;
    }

    public void draw() {
        sketch.circle(x, y, 50);
    }

    public void move() {
        // if y pos > height: force y to bottom=> y = height - radius;
        // else conduct movements
        int direction = (int) sketch.random(0, 100);
        if (direction < 33)
            x = x + RIGHT;
        else if (direction < 66)
            x = x - LEFT;
        else if (direction < 90)
            y = y + DOWN;
        else
            y = y - UP;
    }

}
