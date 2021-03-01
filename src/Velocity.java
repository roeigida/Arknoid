// ID: 322225897.

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 * Support the operations - getters, setters, velocity from angle and speed and applyToPoint.
 */
public class Velocity {
    private double dx;
    private double dy;

    // Constructor

    /**
     * Constructor.
     *
     * @param dx the change in the x axis.
     * @param dy the change in the y axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * add the dx and dy to the point.
     *
     * @param p point with position (x,y).
     * @return a new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        double x = this.dx + p.getX();
        double y = this.dy + p.getY();
        Point nextPoint = new Point(x, y);
        return nextPoint;
    }

    /**
     * @return the dx velocity.
     */
    public double getDxVelocity() {
        return this.dx;
    }

    /**
     * @return the dy velocity.
     */
    public double getDyVelocity() {
        return this.dy;
    }

    /**
     * @param dx1 a velocity on the x axis.
     */
    public void setDx(double dx1) {
        this.dx = dx1;
    }

    /**
     * @param dy1 a velocity on the y axis.
     */
    public void setDy(double dy1) {
        this.dy = dy1;
    }

    /**
     * @return the velocitys' vector size.
     */
    public double getVelocityVectorLength() {
        double vector;
        // Pitagoras.
        vector = Math.sqrt(getDxVelocity() * getDxVelocity() + getDyVelocity() * getDyVelocity());
        return vector;
    }

    /**
     * Constructor.
     *
     * @param angle the angle of the speed.
     * @param speed .
     * @return new velocity expressed by dx and dy.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }
}
