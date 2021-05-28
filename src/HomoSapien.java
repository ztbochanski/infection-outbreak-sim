import processing.core.PApplet;

public class HomoSapien {
    private final int RIGHT = 1;
    private final int LEFT = 1;
    private final int DOWN = 1;
    private final int UP = 1;
    private int x, y;
    private PApplet sketch;
    private String color;
    private int size;

    public HomoSapien(PApplet sketch, String color, int size) {
        this.sketch = sketch;
        this.color = color;
        this.size = size;
        this.x = sketch.width / 2;
        this.y = (sketch.height / 2) + 200;
    }

    /**
     * move
     */
    public void move() {
        int direction = (int) sketch.random(0, 100);
        if (y + 25 > sketch.height) {
            if (direction < 25)
                x = x + RIGHT;
            else if (direction < 25)
                x = x - LEFT;
            else if (direction < 25)
                y = y + DOWN;
            else
                y = y - UP;
        } else {
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

    /**
     * die
     */
    public void die() {
    }

    /**
     * draw
     */
    public void draw() {
        sketch.circle(x, y, 50);
    }

    /**
     * collide
     */
    // public boolean collide(){
    // return;
    // }

}
