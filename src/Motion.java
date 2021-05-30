/**
 * MotionHelper provides static methods to assist with the behavior of how
 * objects can move on the canvas
 */
public class Motion {
    private static final int DISTANCE = 1;

    /**
     * Controls the movement on a horizontal plane.
     * 
     * @param num         argument to determine what direction the object should
     *                    move
     * @param x           value on window
     * @param probability of direction to move: 50 would be 50/50 odds
     * @return new x value
     */
    public static int randomVibrateHorizontal(int num, int x, int probability) {
        if (num < probability)
            return x - DISTANCE;
        else
            return x + DISTANCE;
    }

    /**
     * Controls the movement down on a vertical plane.
     * 
     * @param num         Argument to determine what direction the object should
     *                    move.
     * @param y           Value of position on the window.
     * @param probability Direction to move: 50 would be 50/50 odds
     * @return changed y value.
     */
    public static int randomMoveDown(int num, int y, int probability) {
        if (num < probability)
            return y + DISTANCE;
        else
            return y - DISTANCE;
    }

    /**
     * Controls the movement up on a vertical plane.
     * 
     * @param num         Argument to determine what direction the object should
     *                    move.
     * @param y           The value of position on the window.
     * @param probability Direction to move: 50 would be 50/50 odds
     * @return new y value.
     */
    public static int randomMoveUp(int num, int y, int probability) {
        if (num < probability)
            return y - DISTANCE;
        else
            return y + DISTANCE;
    }

    /**
     * move at a constant rate up
     * 
     * @param y
     * @return new y coordinate
     */
    public static int constantMoveUp(int y) {
        return y - DISTANCE;
    }

    /**
     * move at a constant rate down
     * 
     * @param y
     * @return new y coordinate
     */
    public static int constantMoveDown(int y) {
        return y + DISTANCE;
    }
}
