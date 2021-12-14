/**
 * @author Mohamed Yousef
 */

public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;
    /**
     * @param game the game where to remove it
     * @param remain the number of remained balls
     */
    public BallRemover(GameLevel game, Counter remain) {
        this.game = game;
        this.remainingBalls = remain;
    }

    /**
     * @return the current count
     */
    public int getCounter() {
        return this.remainingBalls.getValue();
    }
    /**
     *Blocks that are hit should be removed from the game.
     * @param beingHit the block that being hit
     * @param hitter The hitter parameter is the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}