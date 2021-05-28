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
        this.y = (sketch.height / 2) + 200;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * move the object use the MotionHelper class to control the left/right/up/down
     * motion
     */
    public void move() {
        int randNum = (int) sketch.random(0, 100);
        setX(MotionHelper.randomVibrateHorizontal(randNum, x, 50));
        // if (y - diameter / 2 < 0) {
        // setY(MotionHelper.randomMoveDown(randNum, y, 100));
        // } else
        // setY(MotionHelper.randomMoveUp(randNum, y, 66));

        // if (y + diameter / 2 > sketch.height) {
        // setY(MotionHelper.randomMoveUp(randNum, y, 100));
        // } else
        // setY(MotionHelper.randomMoveDown(randNum, y, 66));
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
