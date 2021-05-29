
/**
 * The point class provides the behaviors of an x, y coordinate
 */
public class Point {

    private int x;
    private int y;

    /**
     * constructor takes x and y value
     * 
     * @param x value
     * @param y value
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get x
     * 
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * get y
     * 
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * set x
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set y
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}