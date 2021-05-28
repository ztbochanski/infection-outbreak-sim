import processing.core.PApplet;

public class CircleSapien {
    private final int RIGHT = 1;
    private final int LEFT = 1;
    private final int DOWN = 1;
    private final int UP = 1;
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

    public void randomMoveInPlace() {
        int direction = (int) sketch.random(0, 100);
        if (direction < 25)
            x = x + RIGHT;
        else if (direction < 50)
            x = x - LEFT;
        else {
            if (y + diameter / 2 > sketch.height)
                y = y - DOWN;
            else
                y = y + DOWN;
        }
    }

    public void randomMoveDown() {
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

    public void randomMoveUp() {
        int direction = (int) sketch.random(0, 100);
        if (direction < 33)
            x = x + RIGHT;
        else if (direction < 66)
            x = x - LEFT;
        else if (direction < 90)
            y = y - DOWN;
        else
            y = y + UP;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * move
     */
    public void move() {
        // int direction = (int) sketch.random(0, 100);
        if (y + diameter / 2 > sketch.height || y - diameter / 2 < 0)
            // Motion.randomMoveInPlace(direction, x, y);
            randomMoveInPlace();
        else
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

}
