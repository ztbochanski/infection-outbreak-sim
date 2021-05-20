import processing.core.PApplet;

/**
 * This program simulates humans (circles) moving across the canvas towards
 * zombies (more circles), the circles interact with each other and either
 * explode or are turned into additional zombies. The scores or total count is
 * kept on the top and bottom of the screen.
 *
 * CS162 Final Project
 *
 * @author Zachary Bochanski
 * @version 1.0
 * @since 2021.05.19
 */
public class Main {
    private final static String[] OPTIONS = new String[] { "Sketch" };

    public static void main(String[] args) {
        PApplet.main(OPTIONS);
    }

}
