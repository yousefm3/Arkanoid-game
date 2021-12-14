/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Pause Game Class.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    /**
     * @param k the press
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;

    }
    /**
     *
     * @param d where we have the objects
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(15, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }
    /**
     *
     * @return if should stop or not
     */
    public boolean shouldStop() { return this.stop; }
}