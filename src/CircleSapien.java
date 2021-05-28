import processing.core.PApplet;

public class CircleSapien {
    private final int X_DIRECTION = 1;
    private final int Y_DIRECTION = 1;
    private int x, y;
    private int diameter;
    private PApplet sketch;
    private String color;

    public CircleSapien(PApplet sketch, String color, int diameter) {
        this.sketch = sketch;
        this.color = color;
        this.diameter = diameter;
        this.x = sketch.width / 2;
        this.y = (sketch.height / 2) - 200;
    }

    /**
     * move
     */
    public void move() {
        randomMoveUp();
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
        sketch.circle(x, y, diameter);
    }

    /**
     * collide
     */
    // public boolean collide(){
    // return;
    // }

    /**
     * randomly move down and stay within window
     */
    public void randomMoveDown() {
        int direction = (int) sketch.random(0, 100);
        if (direction < 33)
            x = x + X_DIRECTION;
        else if (direction < 66)
            x = x - X_DIRECTION;
        else if (direction < 90) {
            if (y + diameter / 2 > sketch.height)
                y = y - Y_DIRECTION;
            else
                y = y + Y_DIRECTION;
        } else
            y = y - Y_DIRECTION;
    }

    /**
     * randomly move up and stay within window
     */
    public void randomMoveUp() {
        int direction = (int) sketch.random(0, 100);
        if (direction < 33)
            x = x + X_DIRECTION;
        else if (direction < 66)
            x = x - X_DIRECTION;
        else if (direction < 90) {
            if (y - diameter / 2 < 0)
                y = y + Y_DIRECTION;
            else
                y = y - Y_DIRECTION;
        } else
            y = y + Y_DIRECTION;
    }

}
