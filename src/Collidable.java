/**
 * @author Mohamed Yousef
 */
public interface Collidable {
        /**
         * @return  the "collision shape" of the object.
          */
        Rectangle getCollisionRectangle();

        /** Notify the object that we collided with it at collisionPoint with
        * a given velocity.
         * @param collisionPoint where the collision happens
         * @param  currentVelocity current velocity
         * @param hitter the ball that may hit
        * @return is the new velocity expected after the hit (based on
        *the force the object inflicted on us).
         */
        Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

