/**
 * @author Mohamed Yousef
 */

public interface HitListener {
    /** This method is called whenever the beingHit object is hit.
     * @param beingHit the block that being hit
     * @param hitter The hitter parameter is the Ball that's doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}