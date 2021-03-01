// ID: 322225897.

/**
 * a collidable has a shape and know to set a new velocity when hit.
 */
public interface Collidable {
    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param currentVelocity the current balls velocity.
     * @param collisionPoint  the current point the ball collided in.
     * @param hitter          the ball which hit the collidable.
     * @return a new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}