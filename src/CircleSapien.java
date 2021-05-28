import processing.core.PApplet;

public class CircleSapien {
    private PApplet sketch;
    private int color;
    private int x, y;
    private int diameter;

    public CircleSapien(PApplet sketch, int color, int diameter, int x, int y) {
        this.sketch = sketch;
        this.color = color;
        this.diameter = diameter;
        this.x = x;
        this.y = y;
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
        setX(Motion.randomVibrateHorizontal(randNum, x, 50));
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
     * draw on PApplet canvas
     */
    public void draw() {
        sketch.fill(color);
        sketch.noStroke();
        sketch.circle(x, y, diameter);
    }

    /**
     * collide
     */
    // public boolean collide(){
    // return;
    // }

    /**
     * die
     */
    public void die() {
    }
}
