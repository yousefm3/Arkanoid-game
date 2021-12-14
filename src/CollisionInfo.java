/**
 * @author Mohamed Yousef
 */
/**
 * collision info class that has the point of it and the object.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * @param collisionP the collision point
     * @param object the object
     */
    public CollisionInfo(Point collisionP, Collidable object) {
        this.collisionPoint = collisionP;
        this.collisionObject = object;
    }

    /**
     * @return the collision point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    /**
     * @return the collision object
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }

}
