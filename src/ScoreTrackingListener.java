/**
 * @author Mohamed Yousef
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * @param scoreCounter the current score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * @return the current score
     */
    public Counter getCurrentScore() {
        return currentScore;
    }

    /**
     * @param beingHit the block that being hit
     * @param hitter The hitter parameter is the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
            currentScore.increase(5);
    }
}