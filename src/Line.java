// ID: 322225897.

import java.util.ArrayList;

/**
 * Line in two - dimensional space.
 * The class has two constructors of line.
 * Moreover supports the operations -line's length, get the edges point, equals, the slope of the line and intersection.
 */
public class Line {
    private Point start;
    private Point end;

    private static final int FIRST = 0;

    /**
     * Constructor.
     *
     * @param start - starting point.
     * @param end   - ending point.
     */
    // constructors
    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }

    /**
     * Constructor.
     *
     * @param x1 the x value of the starting point.
     * @param y1 the y value of the starting point.
     * @param x2 the x value of the ending point.
     * @param y2 the y value of the ending point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Calculate the length of line.
     *
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Calculate the middle point of the line.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        Point middle = new Point(x, y);
        return middle;
    }

    /**
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Calculate the slope between two points.
     *
     * @param p1 point.
     * @param p2 point.
     * @return the slope between the two points.
     */
    public double slope(Point p1, Point p2) {
        return (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
    }

    /**
     * Checks if two lines are intersecting.
     *
     * @param line other line to check intersection.
     * @return true if the lines intersect, false otherwise.
     */
    //
    public boolean isIntersecting(Line line) {
        Double x1 = null, x2 = null, m1 = null, m2 = null, b1 = null, b2 = null;
        // check if the lines are same.
        if (this.end.equals(line.end()) && this.start.equals(line.start())) {
            return false;
        }
        if (this.end.equals(line.start()) && this.start.equals(line.end())) {
            return false;
        }
        // check if the line is parallel to the Y hinge.
        if (this.start.getX() == this.end.getX()) {
            x1 = this.start.getX();
        }
        if (line.start().getX() == line.end().getX()) {
            x2 = line.start().getX();
        }
        // if its'nt parallel the calculate the slope calculate the cutting point of the line with the Y hinge.
        if (x1 == null) {
            m1 = slope(this.start, this.end);
            b1 = this.start.getY() - m1 * this.start.getX();
        }
        if (x2 == null) {
            m2 = slope(line.start(), line.end());
            b2 = line.start().getY() - m2 * line.start().getX();
        }
        //they're parallel to the Y hinge.
        if (x1 != null && x2 != null) {
            return false;
        }
        // one is parallel to the Y hinge and the other one is'nt.
        if (x1 != null && x2 == null) {
            double y1 = m2 * x1 + b2;
            // checks if the point in the range of the not parallel line.
            if (x1 < line.start().getX() && x1 < line.end().getX()) {
                return false;
            }
            if (x1 > line.start().getX() && x1 > line.end().getX()) {
                return false;
            }
            // checks if the point in the range of the parallel line.
            if (y1 < this.start.getY() && y1 < this.end.getY()) {
                return false;
            }
            if (y1 > this.start.getY() && y1 > this.end.getY()) {
                return false;
            }
            return true;
        }
        if (x1 == null && x2 != null) {
            double y2 = m1 * x2 + b1;
            if (x2 < this.start.getX() && x2 < this.end.getX()) {
                return false;
            }
            if (x2 > this.start.getX() && x2 > this.end.getX()) {
                return false;
            }
            if (y2 < line.start().getY() && y2 < line.end().getY()) {
                return false;
            }
            if (y2 > line.start().getY() && y2 > line.end().getY()) {
                return false;
            }
            return true;
        }
        // there is full line equation for both.
        if (x1 == null && x2 == null) {
            // they're parallel but not cutting the same point on the Y hinge.
            if (m1 == m2 && b1 != b2) {
                return false;
            }
            // they're parallel and cutting the same point on the Y hinge.
            if (m1 == m2 && b1 == b2) {
                // Check if there is intersection in the edges.
                if (this.start.equals(line.end()) || this.start.equals(line.start())) {
                    return true;
                }
                if (this.end.equals(line.end()) || this.end.equals(line.start())) {
                    return true;
                }
                return false;
            }
            // Incase those are just two regular line equations.
            double x = (b2 - b1) / (m1 - m2);
            //check if its in both lines rage
            if (x < line.start().getX() && x < line.end().getX()) {
                return false;
            }
            if (x > line.start().getX() && x > line.end().getX()) {
                return false;
            }
            if (x < this.start.getX() && x < this.end.getX()) {
                return false;
            }
            if (x > this.start.getX() && x > this.end.getX()) {
                return false;
            }
        }
        return true;
    }

    /**
     * if the lines intersecting the calculate the intersection point.
     *
     * @param other line.
     * @return the intersection point if the lines intersect, and null otherwise.
     */

    public Point intersectionWith(Line other) {
        Line line = new Line(this.start, this.end);
        if (line.isIntersecting(other)) {
            // Check if there is intersection in the edges and return it.
            if (line.start().equals(other.end()) || line.start().equals(other.start())) {
                return line.start();
            }
            if (line.end().equals(other.end()) || line.end().equals(other.start())) {
                return line.end();
            }
            Double x1 = null, x2 = null, m1 = null, m2 = null, b1 = null, b2 = null;
            // check if the line is parallel to the Y hinge
            if (line.start().getX() == line.end().getX()) {
                x1 = line.start().getX();
            }
            if (other.start().getX() == other.end().getX()) {
                x2 = other.start().getX();
            }
            // if its'nt parallel the calculate the slope calculate the cutting point of the line with the Y hinge
            if (x1 == null) {
                m1 = slope(line.start(), line.end());
                b1 = line.start().getY() - m1 * line.start().getX();
            }
            if (x2 == null) {
                m2 = slope(other.start(), other.end());
                b2 = other.start().getY() - m2 * other.start().getX();
            }
            if (x1 != null && x2 == null) {
                Point point = new Point(x1, m2 * x1 + b2);
                return point;
            }
            if (x1 == null && x2 != null) {
                Point point = new Point(x2, m1 * x2 + b1);
                return point;
            }
            if (x1 == null & x2 == null) {
                double px = (b2 - b1) / (m1 - m2);
                double py = m1 * px + b1;
                Point point = new Point(px, py);
                return point;
            }
        }
        return null;
    }

    /**
     * Checks if two lines are equals.
     *
     * @param line line.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line line) {
        if (line == null) {
            return false;
        }
        if (this.end.equals(line.end()) && this.start.equals(line.start())) {
            return true;
        }
        if (this.end.equals(line.start()) && this.start.equals(line.end())) {
            return true;
        }
        return false;
    }

    /**
     * the function check of there is intersection point between a line and a rectangle.
     *
     * @param rect a given rectangle that checked on if the current line is intersecting with or not.
     * @return the closest intersection to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Point closer = null;
        double minDistance;
        ArrayList<Point> list = new ArrayList<Point>();
        Line line = new Line(this.start, this.end);
        // gets a list of intersection points of the line with the rectangle.
        list = rect.intersectionPoints(line);
        if (list == null) {
            return null;
        }
        closer = list.get(FIRST);
        minDistance = line.start().distance(closer);
        /* check for the minimum distance from the starting point of the line. */
        for (int i = 1; i < list.size(); i++) {
            if (line.start().distance(list.get(i)) < minDistance) {
                minDistance = line.start().distance(list.get(i));
                closer = list.get(i);
            }
        }
        return closer;
    }
}