//ID: 322225897.

import java.util.ArrayList;

/**
 * class supports getters , rectangle to lines and intersection points of line with the rectangle.
 * implemented by upper left point width and height.
 */
public class Rectangle {
    private static final int SIDES_OF_RECTANGLE = 4;
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor.
     * Create a new rectangle with location and width/height.
     *
     * @param width     the rectangles' width.
     * @param height    the rectangles' height.
     * @param upperLeft the rectangles' upper left point.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * separate the rectangle to lines and check if there is intersection point with the lines.
     * and create a list of the intersection points.
     *
     * @param line a given line checked intersection with the rectangle.
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public ArrayList<Point> intersectionPoints(Line line) {
        // the list will store the intersection points.
        ArrayList<Point> list = new ArrayList<Point>();
        Rectangle rectangle = new Rectangle(this.upperLeft, this.width, this.height);
        Line[] lines = new Line[SIDES_OF_RECTANGLE];
        // creates a lines from the rectangle.
        lines = fromRectangleToLines(rectangle);
        /* check for every line in lines array if the given line is intersecting with them.*/
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].isIntersecting(line)) {
                list.add(lines[i].intersectionWith(line));
            }
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    /**
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * the function return an array of lines that the rectangle made of.
     *
     * @param rectangle a rectangle.
     * @return an array of lines which the rectangle made of
     */
    public Line[] fromRectangleToLines(Rectangle rectangle) {
        // create the rectangles' vertices.
        Point upperLeftPoint = rectangle.getUpperLeft();
        Point upperRight = new Point(rectangle.getUpperLeft().getX() + rectangle.getWidth(),
                rectangle.getUpperLeft().getY());
        Point lowerRight = new Point(rectangle.getUpperLeft().getX() + rectangle.getWidth(),
                rectangle.getUpperLeft().getY() + rectangle.getHeight());
        Point lowerLeft = new Point(rectangle.getUpperLeft().getX(),
                rectangle.getUpperLeft().getY() + rectangle.getHeight());
        //create the slopes of the rectangle.
        Line upper = new Line(upperLeftPoint, upperRight);
        Line lower = new Line(lowerLeft, lowerRight);
        Line left = new Line(upperLeftPoint, lowerLeft);
        Line right = new Line(upperRight, lowerRight);
        // enters the lines to the array.
        Line[] lines = new Line[SIDES_OF_RECTANGLE];
        lines[0] = upper;
        lines[1] = lower;
        lines[2] = left;
        lines[3] = right;
        return lines;

    }
}