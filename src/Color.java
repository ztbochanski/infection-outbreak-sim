import processing.core.PApplet;

/**
 * Generate random base color object
 */
public class Color {
    private final int DEFAULT_ALPHA = 70;
    private int alpha;
    private PApplet sketch;

    /**
     * Color constructor takes PApplet object Initializes object with a default
     * transparency
     * 
     * @param sketch
     */
    public Color(PApplet sketch) {
        this.sketch = sketch;
        this.alpha = DEFAULT_ALPHA;
    }

    /**
     * set custom alpha
     * 
     * @param alpha
     */
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    /**
     * creates color with the first byte all 0s and randomly selects the green and
     * blue bytes
     * 
     * @return rgb as integer value
     */
    public int randomCoolColor() {
        return this.sketch.color(0, sketch.random(32, 220), sketch.random(140, 255), alpha);
    }

    /**
     * creates color with the blue byte all 0s and randomly selects the green and
     * red bytes
     * 
     * @return rgb as integer value
     */
    public int randomWarmColor() {
        return this.sketch.color(sketch.random(140, 255), sketch.random(32, 220), 0, alpha);
    }
}
