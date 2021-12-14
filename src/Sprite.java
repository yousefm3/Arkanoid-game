/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;
/**
 *, a Sprite is a game object that can be drawn to the screen (and which is not just a background image).
 * Sprites can be drawn on the screen, and can be notified that time has passed.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d the surface we are drawing in
     */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}