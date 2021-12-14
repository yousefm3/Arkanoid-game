import biuoop.DrawSurface;
/**
 * @author Mohamed Yousef
 */
public class ScoreIndicator implements Sprite {
    private Counter currentScore;

    /**
     * @param counter the score counter
     */
    public ScoreIndicator(Counter counter) {
        this.currentScore = counter;
    }

    /**
     * @return the current score
     */
    public Counter getCurrentScore() {
        return currentScore;
    }

    /**
     * draw the sprite to the screen.
     * @param d the surface we are drawing in
     */
    public void drawOn(DrawSurface d) {
        d.setColor(java.awt.Color.black);
        d.drawText(380, 30, "score: " + this.currentScore.getValue(), 15);
    }

    /**
     * doing nothing.
     */
    public void timePassed() { }
}