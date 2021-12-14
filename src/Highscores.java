import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Mohamed Yousef
 */
public class Highscores implements Animation {
    private int highScore = 0;
    private KeyboardSensor keyboard;
    private boolean stop;
    /**
     * @param k the press
     */
    public Highscores(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * @param b the boolean
     */
    public void setStop(boolean b) {
        this.stop = b;
    }
    /**
     * @param d where we have the objects
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(50, d.getHeight() / 2, "Your High score is:" + this.highScore, 32);
        d.drawText(50, d.getHeight() / 2 + 50, "press 'm' to return to the menu", 32);
        if (this.keyboard.isPressed("m"))  { this.stop = true; }
    }
    /**
     *
     * @return if should stop or not
     */
    public boolean shouldStop() { return this.stop; }
    /**
     * @return the highScore
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * @param high the one to compare with
     */
    public void checkMax(int high) {
        if (this.highScore < high) {
            this.highScore = high;
        }
    }
}
