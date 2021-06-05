import processing.sound.SoundFile;
import processing.core.PApplet;

public class SoundPlayer {
    private SoundFile file;
    private PApplet sketch;

    /**
     * Sound constructor takes the filename and parent sketch
     *
     * @param sketch   to use
     * @param fileName of file to play
     */
    public SoundPlayer(PApplet sketch, String fileName) {
        this.sketch = sketch;
        file = new SoundFile(this.sketch, fileName);
    }

    /**
     * play the file the is loaded into the sound library
     */
    public void playSound() {
        file.play();
    }
}
