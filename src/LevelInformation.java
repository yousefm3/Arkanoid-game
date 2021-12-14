/**
 * @author Mohamed Yousef
 */
import java.util.List;

/**
 * level info.
 */
public interface LevelInformation {
    /**
     * @return the number of the balss
     */
    int numberOfBalls();

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    /**
     * @return the initial velocity of the ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the paddle speed
     */
    int paddleSpeed();
    /**
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * the level name will be displayed at the top of the screen.
     * @return the level name
     */
    String levelName();

    /**
     *Returns a sprite with the background of the level.
     * @return the background
     */
    Sprite getBackground();

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    /**
     * @return the block list
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    /**
     * @return the number of blocks to remove
     */
    int numberOfBlocksToRemove();
}