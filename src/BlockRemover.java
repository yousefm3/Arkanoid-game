/**
 * @author Mohamed Yousef
 */

public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    /**
     * @param game the game where to remove it
     * @param remain the number of remained blocks
     */
    public BlockRemover(GameLevel game, Counter remain) {
        this.game = game;
        this.remainingBlocks = remain;
    }

    /**
     * @return the current count
     */
    public int getCounter() {
        return this.remainingBlocks.getValue();
    }
    /**
     *Blocks that are hit should be removed from the game.
     * @param beingHit the block that being hit
     * @param hitter The hitter parameter is the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
        hitter.setGameEnvironment(this.game.getEnvironment());
    }
}