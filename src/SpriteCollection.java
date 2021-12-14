/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 *a spriteCollection will hold a collection of sprites.
 */
public class SpriteCollection {
    private List<Sprite> spritesList = new ArrayList<Sprite>();
    /**
     * @param s the sprite we are adding to the sprites list
     */
    public void addSprite(Sprite s) {
        this.spritesList.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
     for (int i = 0; i < spritesList.size(); i++) {
        this.spritesList.get(i).timePassed();
     }
    }
    /**
      *call drawOn(d) on all sprites.
     * @param d the draw surface
     */
    public void drawAllOn(DrawSurface d) {
        //passing the whole sprites
     for (int i = 0; i < spritesList.size(); i++) {
         spritesList.get(i).drawOn(d);
     }
    }
    /**
     * @param s the Sprite we will remove from the environmet
     */
    public void removeSprite(Sprite s) {
        this.spritesList.remove(s);
    }
}