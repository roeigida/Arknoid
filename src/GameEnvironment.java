//ID: 322225897.

import java.util.ArrayList;

/**
 * the game environment.
 * supports getter method, add collidable to the game environment method and get closest collision method.
 * implemented by an array list.
 */
public class GameEnvironment {
    private ArrayList<Collidable> gameEnv;

    /**
     * constructor.
     */
    public GameEnvironment() {
        this.gameEnv = new ArrayList<Collidable>();
    }

    /**
     * @return the game environments' ArrayList of collidables.
     */
    public ArrayList<Collidable> getCollidableList() {
        return this.gameEnv;
    }

    //

    /**
     * add the given collidable to the environment.
     *
     * @param c a collidable object.
     */
    public void addCollidable(Collidable c) {
        this.gameEnv.add(c);
    }

    /**
     * remove a given collidable from the game environment.
     *
     * @param c the collidable that will be remove from the environment.
     */
    public void removeCollidable(Collidable c) {
        this.gameEnv.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     *
     * @param trajectory the line the object moving in.
     * @return a collision info object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo colInfo = null;
        Collidable collided = null;
        Point intersection = null;
        // if the game environment is empty.
        if (this.gameEnv == null) {
            return null;
        }
        /* move through all the collidable objects in the environment and check th closest intersection point.*/
        for (Collidable c : this.gameEnv) {
            // return the closest intersection point if there isn't intersection the return null.
            Point temp = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (temp == null) {
                continue;
            }
            // find an intersection point.
            if (intersection == null
                    || trajectory.start().distance(intersection) > trajectory.start().distance(temp)) {
                intersection = temp;
                collided = c;
                // sets the closest intersection of collidable object.
                colInfo = new CollisionInfo(intersection, collided);
            }
        }
        return colInfo;
    }
}
