/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;

/**
 * Animation class.
 */
public interface Animation {
    /**
     * @param d where we have the objects
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return if we should stop or not
     */
    boolean shouldStop();
}