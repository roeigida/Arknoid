// ID: 322225897.

/**
 * A point in two - dimensional space.
 * The class support getters and setters operations moreover equals and distance between two points.
 * The point implemented by two double values.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Point constructor.
     *
     * @param x a number on the x axis.
     * @param y a number on the y axis.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Measuring distance between two points.
     *
     * @param point another point to measure the distance.
     * @return double distance - the distance between the current point to the given one.
     */
    public double distance(Point point) {
        double distance, a, b;
        // The distance between two points
        a = this.x - point.getX();
        b = this.y - point.getY();
        // using Pitagoras to calculate the distance of two points.
        distance = Math.sqrt(a * a + b * b);
        return distance;
    }

    /**
     * Checks if two points rae equals.
     *
     * @param point other point.
     * @return boolean - true if the points are equal, false otherwise
     */
    public boolean equals(Point point) {
        if (this.x == point.getX() && this.y == point.getY()) {
            return true;
        }
        return false;
    }

    /**
     * @return double - the x value of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return double - the y value of this point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param x1 the x coordinate.
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * @param y1 the y coordinate.
     */
    public void setY(double y1) {
        this.y = y1;
    }
}
