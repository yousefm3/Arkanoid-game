/**
 * @author Mohamed Yousef
 */
import java.util.ArrayList;
import java.util.List;

/**
 * The GameEnvironment class will be a collection of such things.
 * The ball will know the game environment,
 * and will use it to check for collisions and direct its movement.
 */
public class GameEnvironment {
    private List<Collidable> collidables = new ArrayList<Collidable>();
    /**
     * @param c the collidable that we add to the collidables list
     *  add the given collidable to the environment.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    /**
     * @param trajectory the current move that the ball's make
     * @return the collision info if there is one , else null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // passing every callable
        for (Collidable c : collidables) {
            Rectangle r = c.getCollisionRectangle();
            // checking if there is intersecting point
            if (r.intersectionPoints(trajectory).size() > 0) {
                // getting the closest one
                Point collisionPoint = trajectory.closestIntersectionToStartOfLine(r);
                CollisionInfo d = new CollisionInfo(collisionPoint, c);
                return d;
            }
        }
        return null;
    }
    /**
     * @param c the Collidable we will remove from the environmet
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
}
