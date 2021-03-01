// ID: 322225897.

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Ball in two - dimensional space.
 * The class support getters and setters operations moreover draw and move one step.
 * implemented by color center point radius and velocity.
 */
public class Ball implements Sprite {
    private GameEnvironment gameEnv;
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;

    private static final double EPSILON = 0.000001;

    // constructor

    /**
     * Constructor.
     *
     * @param gameEnv the game environment.
     * @param center  the center point of the ball.
     * @param color   the ball's color.
     * @param r       the ball's radius.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnv) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = null;
        this.gameEnv = gameEnv;
    }

    /**
     * Additional constructor.
     *
     * @param gameEnv the game environment
     * @param x       the x of the center point.
     * @param y       the y of the center point.
     * @param color   the ball's color.
     * @param r       the ball's radius.
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment gameEnv) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
        this.velocity = null;
        this.gameEnv = gameEnv;
    }

    // accessors

    /**
     * @return the center's x.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return the center's y.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the ball's radius.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * @return the ball's center.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * @return the ball's color.
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface a draw surface.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawCircle(getX(), getY(), getSize());
        surface.setColor(getColor());
        surface.fillCircle(getX(), getY(), getSize());
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Sets the ball's velocity.
     *
     * @param v velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets the ball's velocity by the two components dx and yx.
     *
     * @param dx the velocity in the x axis.
     * @param dy the velocity in the y axis.
     */
    public void setVelocity(double dx, double dy) {
        Velocity v = new Velocity(dx, dy);
        this.velocity = v;
    }

    /**
     * @return the ball's velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }


    /***
     * @return game environment
     */
    public GameEnvironment getGameEnv() {
        return gameEnv;
    }

    /**
     * Sets a new center to the ball by stay in the boundaries.
     */
    public void moveOneStep() {
        Point start = this.center;
        // Doing a regular step.
        this.center = getVelocity().applyToPoint(this.center);
        Line trajectory = new Line(start, this.center);
        CollisionInfo collInfo = this.gameEnv.getClosestCollision(trajectory);
        if (collInfo == null) {
            return;
        }
        Point collPoint = new Point(collInfo.collisionPoint().getX(), collInfo.collisionPoint().getY());
        this.center = getBackSlightBit(this.velocity, collPoint);
        // creates the hit block.
        this.velocity = collInfo.collisionObject().hit(this, collInfo.collisionPoint(), this.velocity);

    }

    /**
     * takes the balls' center a little bit back according to the velocity.
     *
     * @param v     velocity.
     * @param point the center.
     * @return the given point an epsilon distance back according the velocity.
     */
    public Point getBackSlightBit(Velocity v, Point point) {
        // the ball going right.
        if (v.getDxVelocity() > 0) {
            point.setX(point.getX() - EPSILON);
        }
        // the ball going  left.
        if (v.getDxVelocity() < 0) {
            point.setX(point.getX() + EPSILON);
        }
        // the ball going down.
        if (v.getDyVelocity() > 0) {
            point.setY(point.getY() - EPSILON);
        }
        // the ball going up.
        if (v.getDyVelocity() < 0) {
            point.setY(point.getY() + EPSILON);
        }
        return point;
    }

    /**
     * removes the ball from the game.
     *
     * @param g the game the ball will be removed from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
