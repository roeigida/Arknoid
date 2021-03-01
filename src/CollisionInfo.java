//ID: 322225897.

/**
 * an info of happened collision.
 * class supports getters.
 * implemented by collision point and collision object.
 */
public class CollisionInfo {
    private Point collPoint;
    private Collidable collObj;

    /**
     * constructor.
     *
     * @param collObj   the object the ball have collided with.
     * @param collPoint the point where the collision occurs.
     */
    public CollisionInfo(Point collPoint, Collidable collObj) {
        this.collObj = collObj;
        this.collPoint = collPoint;
    }

    /**
     * the point at which the collision occurs.
     *
     * @return the collision point.
     */
    public Point collisionPoint() {
        return this.collPoint;
    }


    /**
     * the collidable object involved in the collision.
     *
     * @return the collision object
     */
    public Collidable collisionObject() {
        return this.collObj;
    }

}