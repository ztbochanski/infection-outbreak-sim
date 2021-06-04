import processing.core.PApplet;

class Particle {

    private static final double ACCELERATION = 0.1;
    private static final float MIN_XVELOCITY = -2;
    private static final float MAX_XVELOCITY = 2;
    private static final float MIN_YVELOCITY = -4;
    private static final float MAX_YVELOCITY = 0;
    private static final float MIN_RADIUS = 2;
    private static final float MAX_RADIUS = 10;
    private static final float ALPHA = 75;

    private PApplet sketch;
    private float x;
    private float y;
    private float xVelocity;
    private float yVelocity;
    private int color;
    private float radius;

    public Particle(PApplet sketch) {
        this(sketch.mouseX, sketch.mouseY, sketch);
    }

    public Particle(int x, int y, PApplet sketch) {
        this.x = x;
        this.y = y;
        this.sketch = sketch;
        xVelocity = sketch.random(MIN_XVELOCITY, MAX_XVELOCITY);
        yVelocity = sketch.random(MIN_YVELOCITY, MAX_YVELOCITY);
        color = sketch.color(sketch.random(255), sketch.random(255), sketch.random(255), ALPHA);
        radius = sketch.random(MIN_RADIUS, MAX_RADIUS);
    }

    public void draw() {
        sketch.stroke(150);
        sketch.fill(color);
        sketch.ellipse(x, y, radius, radius);
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
        yVelocity += ACCELERATION;
    }

    public boolean isOffScreen() {
        return y + radius > sketch.height;
    }
}